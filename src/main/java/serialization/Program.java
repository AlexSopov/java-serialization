package serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import serialization.data.MinecraftBlock;
import serialization.data.MinecraftBlockCraft;
import serialization.data.MinecraftBlockIdentifier;
import serialization.infrastructure.Serializer;
import serialization.serializers.GsonSerializer;
import serialization.serializers.JacksonSerializer;
import serialization.serializers.MinecraftBlockOrgJsonSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<MinecraftBlock> minecraftBlockList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            minecraftBlockList.add(generateBlock());
        }

        getPerfomance(new GsonSerializer<MinecraftBlock>(MinecraftBlock.class), minecraftBlockList);
        getPerfomance(new JacksonSerializer<MinecraftBlock>(MinecraftBlock.class), minecraftBlockList);
        getPerfomance(new MinecraftBlockOrgJsonSerializer(), minecraftBlockList);
    }

    public static void getPerfomance(Serializer<MinecraftBlock> serializer, Iterable<MinecraftBlock> blocksToSerialize) {
        if (serializer == null || blocksToSerialize == null) {
            throw new IllegalArgumentException();
        }

        MetrcisCollector metrcisCollector = new MetrcisCollector();
        metrcisCollector.start();

        List<String> serialized = new ArrayList<String>();
        blocksToSerialize.forEach(block -> {
            try {
                serialized.add(serializer.serialize(block));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        serialized.forEach(serializedString -> {
            try {
                serializer.deserialize(serializedString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        metrcisCollector.end();

        System.out.println(metrcisCollector.getMetricsString());
        System.out.println();
    }

    public static MinecraftBlock generateBlock() {
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("A", "minecraft:planks");

        MinecraftBlockCraft minecraftBlockCraft = new MinecraftBlockCraft("AAAA", myMap, false);
        ArrayList<MinecraftBlockCraft> minecraftBlockCrafts = new ArrayList<MinecraftBlockCraft>();
        minecraftBlockCrafts.add(minecraftBlockCraft);

        MinecraftBlockIdentifier minecraftBlockIdentifier = new MinecraftBlockIdentifier(1, 1);

        return new MinecraftBlock("Crafting table", "minecraft:crafting_table", 64, minecraftBlockCrafts, minecraftBlockIdentifier);
    }
}
