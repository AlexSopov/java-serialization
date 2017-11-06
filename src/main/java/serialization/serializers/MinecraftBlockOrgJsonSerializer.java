package serialization.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import serialization.data.MinecraftBlock;
import serialization.data.MinecraftBlockCraft;
import serialization.data.MinecraftBlockIdentifier;

import java.io.IOException;
import java.util.*;

public class MinecraftBlockOrgJsonSerializer extends OrgJsonSerializer<MinecraftBlock> {

    public MinecraftBlockOrgJsonSerializer() {
        super(MinecraftBlock.class);
    }

    @Override
    public MinecraftBlock deserialize(String serializedValue) throws IOException {
        JSONObject jsonObjectFromSerializedValue = new JSONObject(serializedValue);
        JSONArray crafts = jsonObjectFromSerializedValue.getJSONArray("crafts");

        List<MinecraftBlockCraft> minecraftBlockCraftList = new ArrayList<>();
        for (Object craft : crafts) {
            JSONObject craftJSONObject = (JSONObject)craft;

            String schema = craftJSONObject.getString("schema");
            Boolean isFormCraft = craftJSONObject.getBoolean("formCraft");
            Map<String, String> schemaData = parseJsonToMap(craftJSONObject.getJSONObject("schemaData"));

            minecraftBlockCraftList.add(new MinecraftBlockCraft(schema, schemaData, isFormCraft));
        }

        JSONObject idJSONObject = jsonObjectFromSerializedValue.getJSONObject("minecraftBlockIdentifier");
        MinecraftBlockIdentifier minecraftBlockIdentifier = new MinecraftBlockIdentifier(
                idJSONObject.getInt("majorId"),
                idJSONObject.getInt("minorId")
        );

        return new MinecraftBlock(
                jsonObjectFromSerializedValue.getString("blockName"),
                jsonObjectFromSerializedValue.getString("technicalName"),
                jsonObjectFromSerializedValue.getInt("stackCapacity"),
                minecraftBlockCraftList,
                minecraftBlockIdentifier
        );
    }

    @Override
    public String serialize(MinecraftBlock serializableObject) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject(serializableObject);
        return jsonObject.toString();
    }

    private Map<String, String> parseJsonToMap(JSONObject jsonObject) throws JSONException {
        HashMap<String, String> map = new HashMap<String, String>();
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            String value = jsonObject.getString(key);
            map.put(key, value);
        }

        return map;
    }
}
