import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serialization.data.MinecraftBlock;
import serialization.data.MinecraftBlockCraft;
import serialization.data.MinecraftBlockIdentifier;
import serialization.serializers.GsonSerializer;
import serialization.serializers.JacksonSerializer;
import serialization.serializers.MinecraftBlockOrgJsonSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SerializaersTest  {
    MinecraftBlock minecraftBlock;

    @Before
    public void before() {
        HashMap<String, String> myMap = new HashMap<String, String>();
        myMap.put("A", "minecraft:planks");

        MinecraftBlockCraft minecraftBlockCraft = new MinecraftBlockCraft("AAAA", myMap, false);
        ArrayList<MinecraftBlockCraft> minecraftBlockCrafts = new ArrayList<MinecraftBlockCraft>();
        minecraftBlockCrafts.add(minecraftBlockCraft);

        MinecraftBlockIdentifier minecraftBlockIdentifier = new MinecraftBlockIdentifier(1, 1);

        minecraftBlock =  new MinecraftBlock("name1", "na:na", 64, minecraftBlockCrafts, minecraftBlockIdentifier);
    }

    @Test
    public void testGsonSerializer() {
        GsonSerializer<MinecraftBlock> gsonSerializer = new GsonSerializer<>(MinecraftBlock.class);
        String serializedValue = gsonSerializer.serialize(minecraftBlock);
        MinecraftBlock deserizlied = gsonSerializer.deserialize(serializedValue);

        Assert.assertEquals(minecraftBlock, deserizlied);
    }

    @Test
    public void testJsonSerializer() {
        MinecraftBlockOrgJsonSerializer minecraftBlockOrgJsonSerializer = new MinecraftBlockOrgJsonSerializer();
        try {
            String serializedValue = minecraftBlockOrgJsonSerializer.serialize(minecraftBlock);
            MinecraftBlock deserizlied = minecraftBlockOrgJsonSerializer.deserialize(serializedValue);
            Assert.assertEquals(minecraftBlock, deserizlied);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Test
    public void testJacksonSerializer() throws IOException {
        JacksonSerializer<MinecraftBlock> jacksonSerializer = new JacksonSerializer<>(MinecraftBlock.class);

        try {
            String serializedValue = jacksonSerializer.serialize(minecraftBlock);
            MinecraftBlock deserizlied = jacksonSerializer.deserialize(serializedValue);
            Assert.assertEquals(minecraftBlock, deserizlied);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
