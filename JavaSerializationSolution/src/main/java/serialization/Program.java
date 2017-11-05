package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serialization.data.MinecraftBlock;
import serialization.data.MinecraftBlockCraft;
import serialization.infrastructure.Serializer;
import serialization.serializers.GsonSerializer;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        MinecraftBlock obj = generateBlock();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(obj);


        MinecraftBlock vobj = gson.fromJson(json, MinecraftBlock.class);
        System.out.println(json);
    }

    public static MinecraftBlock generateBlock() {
        HashMap myMap = new HashMap<String, String>();
        myMap.put("A", "minecraft:planks");

        MinecraftBlockCraft minecraftBlockCraft = new MinecraftBlockCraft("AAAA", myMap, false);
        ArrayList<MinecraftBlockCraft> minecraftBlockCrafts = new ArrayList<MinecraftBlockCraft>();
        minecraftBlockCrafts.add(minecraftBlockCraft);


        return new MinecraftBlock("name1", "na:na", 64, minecraftBlockCrafts);
    }
}
