package serialization.data;

import java.util.List;

public class MinecraftBlock {
    private String blockName;
    private String technicalName;
    private int stackCapacity;
    private List<MinecraftBlockCraft> crafts;

    public MinecraftBlock(String blockName, String technicalName, int stackCapacity, List<MinecraftBlockCraft> crafts) {
        this.blockName = blockName;
        this.technicalName = technicalName;
        this.stackCapacity = stackCapacity;
        this.crafts = crafts;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public int getStackCapacity() {
        return stackCapacity;
    }

    public void setStackCapacity(int stackCapacity) {
        this.stackCapacity = stackCapacity;
    }
}
