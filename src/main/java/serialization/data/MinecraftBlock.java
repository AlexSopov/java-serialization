package serialization.data;

import java.util.List;

public class MinecraftBlock {
    private String blockName;
    private String technicalName;
    private int stackCapacity;
    private List<MinecraftBlockCraft> crafts;
    private MinecraftBlockIdentifier minecraftBlockIdentifier;

    public MinecraftBlock(String blockName, String technicalName, int stackCapacity, List<MinecraftBlockCraft> crafts, MinecraftBlockIdentifier minecraftBlockIdentifier) {
        this.blockName = blockName;
        this.technicalName = technicalName;
        this.stackCapacity = stackCapacity;
        this.crafts = crafts;
        this.minecraftBlockIdentifier = minecraftBlockIdentifier;
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

    public MinecraftBlockIdentifier getMinecraftBlockIdentifier() {
        return minecraftBlockIdentifier;
    }

    public void setMinecraftBlockIdentifier(MinecraftBlockIdentifier minecraftBlockIdentifier) {
        this.minecraftBlockIdentifier = minecraftBlockIdentifier;
    }

    public List<MinecraftBlockCraft> getCrafts() {
        return crafts;
    }

    public void setCrafts(List<MinecraftBlockCraft> crafts) {
        this.crafts = crafts;
    }
}
