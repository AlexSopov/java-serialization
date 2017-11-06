package serialization.serializers;

import com.google.gson.Gson;
import serialization.infrastructure.Serializer;

public class GsonSerializer<T> extends Serializer<T> {
    private Gson gson;

    public GsonSerializer(Class<T> typeParameterClass) {
        super(typeParameterClass);
        gson = new Gson();
    }

    @Override
    public T deserialize(String serializedValue) {
        return gson.fromJson(serializedValue, genericParameterClass);
    }

    @Override
    public String serialize(T serializableObject) {
        return gson.toJson(serializableObject, genericParameterClass);
    }
}
