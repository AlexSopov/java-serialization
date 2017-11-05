package serialization.infrastructure;

public interface Serializer<T> {
    T deserialize(String serializedValue);
    void serialize(T serializableObject);
}
