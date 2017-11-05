package serialization.serializers;

import serialization.infrastructure.Serializer;

public class JacksonSerializer<T> implements Serializer<T> {

    public T deserialize(String serializedValue) {
        return null;
    }

    public void serialize(T serializableObject) {

    }
}
