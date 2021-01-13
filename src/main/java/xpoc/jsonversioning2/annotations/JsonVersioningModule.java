package xpoc.jsonversioning2.annotations;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

/**
 * Registering this Json Versioning module to the Jackson
 */
public class JsonVersioningModule extends SimpleModule {
    public JsonVersioningModule() {
        setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                JsonVersioned jsonVersioned = beanDesc.getClassAnnotations().get(JsonVersioned.class);
                if (jsonVersioned != null && BeanDeserializer.class.isInstance(deserializer)) {
                    return new JsonVersioningDeserializer(jsonVersioned, config, beanDesc, (BeanDeserializer) deserializer);
                }
                return super.modifyDeserializer(config, beanDesc, deserializer);
            }
        });

        setSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
                JsonVersioned jsonVersioned = beanDesc.getClassAnnotations().get(JsonVersioned.class);
                if (jsonVersioned != null && BeanSerializer.class.isInstance(serializer)) {
                    return new xpoc.jsonversioning2.annotations.JsonVersioningSerializer(jsonVersioned, beanDesc, (BeanSerializerBase) serializer);
                }
                return super.modifySerializer(config, beanDesc, serializer);
            }
        });
    }
}