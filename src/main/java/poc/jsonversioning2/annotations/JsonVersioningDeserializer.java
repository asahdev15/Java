package poc.jsonversioning2.annotations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;

import java.io.IOException;
/**
 *
 */
public class JsonVersioningDeserializer extends BeanDeserializer {
    private final  DeserializationConfig config;
    private final  BeanDescription beanDesc;
    private final  BeanDeserializer deserializer;

    private final Version modelVersion;
    private final BeanPropertyDefinition jsonVersionProperty;

    public JsonVersioningDeserializer(
            JsonVersioned jsonVersionedAnnotation,
            DeserializationConfig config,
            BeanDescription beanDesc,
            BeanDeserializer deserializer) {
        super(deserializer);
        this.config = config;
        this.beanDesc = beanDesc;
        this.deserializer = deserializer;

        modelVersion = poc.jsonversioning2.annotations.Version.fromString(jsonVersionedAnnotation.value());
        BeanPropertyDefinition versionProperty = null;
        for (BeanPropertyDefinition propertyDef: beanDesc.findProperties()) {
            if ((propertyDef.hasGetter() && propertyDef.getGetter().hasAnnotation(poc.jsonversioning2.annotations.JsonVersionProperty.class))
                    || (propertyDef.hasField() && propertyDef.getField().hasAnnotation(poc.jsonversioning2.annotations.JsonVersionProperty.class))) {
                // Only support one attribute with JsonVersionProperty annotation
                versionProperty = propertyDef;
                break;
            }
        }
        jsonVersionProperty = versionProperty;

    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        final ObjectNode jsonNode = jsonParser.readValueAsTree();
        Version jsonVersion = modelVersion;
        try {
            if (jsonVersionProperty != null && jsonNode.has(jsonVersionProperty.getName())) {
                    jsonVersion = poc.jsonversioning2.annotations.Version.fromString(jsonNode.get(jsonVersionProperty.getName()).asText());
            } else {
                Object jsonVersionObj = ctx.getAttribute(poc.jsonversioning2.annotations.Version.JsonVersionConfigDeserializing);
                if (jsonVersionObj != null) {
                    if (jsonVersionObj instanceof Version)
                        jsonVersion = (Version) jsonVersionObj;
                    else
                        jsonVersion = poc.jsonversioning2.annotations.Version.fromString(jsonVersionObj.toString());
                }
            }
        } catch (IllegalArgumentException e) {
            throw ctx.mappingException("Failed to parse version string: %s", e.getMessage(), e);
        }

        if (modelVersion.compareTo(jsonVersion) < 0) {
            throw ctx.mappingException(
                    "JSON version (%s) is greater than the latest model version (%s)",
                    jsonVersion.toString(), modelVersion.toString());
        }

        Optional<BeanPropertyDefinition> propertyNotInVersion = FluentIterable.from(beanDesc.findProperties())
                // Find the properties that should not be in this version of json
                .filter(Predicates.not(poc.jsonversioning2.annotations.JsonVersioningPredicate.forPropertyDefInVersion(jsonVersion)))
                // see if any of those invalid property names is in the json
                .firstMatch(new Predicate<BeanPropertyDefinition>() {
                    public boolean apply(BeanPropertyDefinition beanPropertyDefinition) {
                        return jsonNode.has(beanPropertyDefinition.getName());
                    }
                });

        if (propertyNotInVersion.isPresent()) {
            throw ctx.mappingException("Property \"%s\" is not in version %s",
                    propertyNotInVersion.get().getName(), jsonVersion.toString());
        }

        // If there is no json version in the json body, insert the version to the json version property (if exists)
        if (jsonVersionProperty != null &&
                Strings.isNullOrEmpty(jsonNode.findPath(jsonVersionProperty.getName()).asText()))
            jsonNode.put(jsonVersionProperty.getName(), jsonVersion.toString());

        JsonParser postInterceptionParser = new TreeTraversingParser(jsonNode, jsonParser.getCodec());
        postInterceptionParser.nextToken();
        return deserializer.deserialize(postInterceptionParser, ctx);

    }

    class PredicateTest implements Predicate<BeanPropertyDefinition>{
        ObjectNode jsonNode = null;
        public boolean apply(BeanPropertyDefinition beanPropertyDefinition) {
            return jsonNode.has(beanPropertyDefinition.getName());
        }
    }
}