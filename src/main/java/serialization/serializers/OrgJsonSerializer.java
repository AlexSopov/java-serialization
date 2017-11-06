package serialization.serializers;

import serialization.infrastructure.Serializer;

public abstract class OrgJsonSerializer<T> extends Serializer<T> {

    public OrgJsonSerializer(Class<T> typeParameterClass) {
        super(typeParameterClass);
    }

}