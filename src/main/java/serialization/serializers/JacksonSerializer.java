package serialization.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import serialization.infrastructure.Serializer;

import java.io.IOException;

public class JacksonSerializer<T> extends Serializer<T> {
    ObjectMapper objectMapper;

    public JacksonSerializer(Class<T> typeParameterClass) {
        super(typeParameterClass);
        objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    }

    @Override
    public T deserialize(String serializedValue) throws IOException {
        return objectMapper.readValue(serializedValue, genericParameterClass);
    }

    @Override
    public String serialize(T serializableObject) throws JsonProcessingException {
        return objectMapper.writeValueAsString(serializableObject);
    }
}
