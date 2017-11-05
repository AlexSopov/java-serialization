package serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serialization.data.MinecraftBlock;
import serialization.data.MinecraftBlockCraft;
import serialization.data.MinecraftBlockIdentifier;
import serialization.infrastructure.Serializer;
import serialization.serializers.GsonSerializer;
import serialization.serializers.JacksonSerializer;
import serialization.serializers.MinecraftBlockOrgJsonSerializer;
import serialization.serializers.OrgJsonSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        MinecraftBlock obj = generateBlock();

        MinecraftBlockOrgJsonSerializer  minecraftBlockGsonSerializer3= new MinecraftBlockOrgJsonSerializer();

        try {
            minecraftBlockGsonSerializer3.deserialize(minecraftBlockGsonSerializer3.serialize(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }

        test(minecraftBlockGsonSerializer3, obj);

    }

    private static void test(Serializer a, MinecraftBlock minecraftBlock) {
        try {
            System.out.println(a.serialize(minecraftBlock));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    private static MinecraftBlock generateBlock() {
        HashMap<String, String> myMap = new HashMap<String, String>();
        myMap.put("A", "minecraft:planks");

        MinecraftBlockCraft minecraftBlockCraft = new MinecraftBlockCraft("AAAA", myMap, false);
        ArrayList<MinecraftBlockCraft> minecraftBlockCrafts = new ArrayList<MinecraftBlockCraft>();
        minecraftBlockCrafts.add(minecraftBlockCraft);

        MinecraftBlockIdentifier minecraftBlockIdentifier = new MinecraftBlockIdentifier(1, 1);

        return new MinecraftBlock("name1", "na:na", 64, minecraftBlockCrafts, minecraftBlockIdentifier);
    }
}
