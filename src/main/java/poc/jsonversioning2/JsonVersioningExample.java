package poc.jsonversioning2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import poc.jsonversioning2.annotations.JsonVersioningModule;
import poc.jsonversioning2.annotations.Version;

import java.io.IOException;

public class JsonVersioningExample {
    protected ObjectReader reader;
    protected ObjectWriter writer;

    public JsonVersioningExample() {
        // Register versioning module to the Jackson mapper
        ObjectMapper mapper = new ObjectMapper().registerModule(new JsonVersioningModule());
        reader = mapper.reader(); // reader is initialized without json version, the POJO model version will be used.
        writer = mapper.writer(); // writer is initialized without json version, the POJO model version will be used.
    }

    public void setDeserializingJsonVersion(String jsonVersion) {
        // reader is replaced by a new reader instance that will have this attribute set.
        reader = reader.withAttribute(
                Version.JsonVersionConfigDeserializing,
                Version.fromString(jsonVersion));
    }
    public void setSerializingJsonVersion(String jsonVersion) {
        // reader is replaced by a new reader instance that will have this attribute set.
        writer = writer.withAttribute(
                Version.JsonVersionConfigSerializing,
                Version.fromString(jsonVersion));
    }

    public String serialize(ModelPojo pojo) throws JsonProcessingException{
        // using the same writer to serialize pojos with the same target JSON version
        return writer.writeValueAsString(pojo);
    }

    public String serialize(ModelPojo pojo, String jsonVersion) throws JsonProcessingException {
        // Or make a new writer with the new version setting
        return writer
                .withAttribute(Version.JsonVersionConfigSerializing, jsonVersion)
                .writeValueAsString(pojo);
    }

    public ModelPojo deserialize(String json) throws IOException {
        // using the same reader to deserialize JSON in the same version
        return reader
                .forType(ModelPojo.class)
                .readValue(json);
    }

    public ModelPojo deserialize(String json, String jsonVersion) throws IOException {
        // Or make a new reader with the new version setting
        return reader
                .withAttribute(Version.JsonVersionConfigDeserializing, jsonVersion)
                .forType(ModelPojo.class)
                .readValue(json);
    }
    
}