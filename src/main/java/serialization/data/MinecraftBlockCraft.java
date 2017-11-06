package serialization.data;

import java.util.HashMap;
import java.util.Map;

public class MinecraftBlockCraft {
    private String schema;
    private Map<String, String> schemaData;
    private Boolean isFormCraft;

    public MinecraftBlockCraft() {
        this("", new HashMap<String, String>(), false);
    }

    public MinecraftBlockCraft(String schema, Map<String, String> schemaData, Boolean isFormCraft) {
        this.schema = schema;
        this.schemaData = schemaData;
        this.isFormCraft = isFormCraft;
    }

    public Boolean getFormCraft() {
        return isFormCraft;
    }

    public void setFormCraft(Boolean formCraft) {
        isFormCraft = formCraft;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Map<String, String> getSchemaData() {
        return schemaData;
    }

    public void setSchemaData(Map<String, String> schemaData) {
        this.schemaData = schemaData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MinecraftBlockCraft)) return false;

        MinecraftBlockCraft that = (MinecraftBlockCraft) o;

        return schema.equals(that.schema) && schemaData.equals(that.schemaData) && isFormCraft.equals(that.isFormCraft);
    }
}
