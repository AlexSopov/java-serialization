package serialization.data;

import java.util.ArrayList;
import java.util.List;

public class MinecraftBlock {
    private String blockName;
    private String technicalName;
    private int stackCapacity;
    private List<MinecraftBlockCraft> crafts;
    private MinecraftBlockIdentifier minecraftBlockIdentifier;

    public MinecraftBlock() {
        this("", "", 0, new ArrayList<MinecraftBlockCraft>(), new MinecraftBlockIdentifier(0, 0));
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MinecraftBlock)) {
            return false;
        }

        MinecraftBlock that = (MinecraftBlock) o;

        return stackCapacity == that.stackCapacity &&
                blockName.equals(that.blockName) &&
                technicalName.equals(that.technicalName) &&
                crafts.equals(that.crafts) &&
                minecraftBlockIdentifier.equals(that.minecraftBlockIdentifier);
    }

    @Override
    public int hashCode() {
        int result = blockName.hashCode();
        result = 31 * result + technicalName.hashCode();
        result = 31 * result + stackCapacity;
        result = 31 * result + crafts.hashCode();
        result = 31 * result + minecraftBlockIdentifier.hashCode();
        return result;
    }
}
