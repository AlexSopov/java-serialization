package serialization.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public abstract class Serializer<T> {
    protected final Class<T> genericParameterClass;

    public Serializer(Class<T> genericParameterClass) {
        this.genericParameterClass = genericParameterClass;
    }

    public abstract T deserialize(String serializedValue) throws IOException;
    public abstract String serialize(T serializableObject) throws JsonProcessingException;
}
