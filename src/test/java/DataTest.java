import org.junit.Assert;
import org.junit.Test;
import serialization.data.MinecraftBlock;
import serialization.data.MinecraftBlockCraft;
import serialization.data.MinecraftBlockIdentifier;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTest {


    @Test
    public void MinecraftBlockCraftEqualityTest() {
        HashMap<String, String> craftData = new HashMap<>();
        craftData.put("A", "minecraft:planks");
        HashMap<String, String> craftData2 = new HashMap<>();
        craftData.put("A", "minecraft:planks");

        MinecraftBlockCraft minecraftBlockCraft = new MinecraftBlockCraft("AAAA", craftData, false);
        MinecraftBlockCraft minecraftBlockCraft2 = new MinecraftBlockCraft("AAAA", craftData, false);
        MinecraftBlockCraft minecraftBlockCraft3 = new MinecraftBlockCraft("AAAAAAAAA", craftData, false);

        Assert.assertEquals(minecraftBlockCraft, minecraftBlockCraft2);
        Assert.assertNotEquals(minecraftBlockCraft, minecraftBlockCraft3);
    }

    @Test
    public void MinecraftBlockIdEqualityTest() {
        MinecraftBlockIdentifier minecraftBlockIdentifier = new MinecraftBlockIdentifier(1, 10);
        MinecraftBlockIdentifier minecraftBlockIdentifier2 = new MinecraftBlockIdentifier(1, 11);
        MinecraftBlockIdentifier minecraftBlockIdentifier3 = new MinecraftBlockIdentifier(1, 10);

        Assert.assertEquals(minecraftBlockIdentifier, minecraftBlockIdentifier3);
        Assert.assertEquals(minecraftBlockIdentifier2, minecraftBlockIdentifier3);
    }

    @Test
    public void MinecraftBlockEqualityTest() {
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("A", "minecraft:planks");

        MinecraftBlockCraft minecraftBlockCraft = new MinecraftBlockCraft("AAAA", myMap, false);
        ArrayList<MinecraftBlockCraft> minecraftBlockCrafts = new ArrayList<MinecraftBlockCraft>();
        minecraftBlockCrafts.add(minecraftBlockCraft);

        MinecraftBlockIdentifier minecraftBlockIdentifier = new MinecraftBlockIdentifier(1, 1);

        MinecraftBlock minecraftBlock1 = new MinecraftBlock("Crafting table", "minecraft:crafting_table", 64, minecraftBlockCrafts, minecraftBlockIdentifier);
        MinecraftBlock minecraftBlock2 = new MinecraftBlock("Crafting table", "minecraft:crafting_table", 16, minecraftBlockCrafts, minecraftBlockIdentifier);
        MinecraftBlock minecraftBlock3 = new MinecraftBlock("Crafting table", "minecraft:crafting_table", 64, minecraftBlockCrafts, minecraftBlockIdentifier);

        Assert.assertEquals(minecraftBlock1, minecraftBlock3);
        Assert.assertNotEquals(minecraftBlock1, minecraftBlock2);
    }
}