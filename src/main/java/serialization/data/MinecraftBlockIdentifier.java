package serialization.data;

public class MinecraftBlockIdentifier {
    private int majorId;
    private int minorId;

    public MinecraftBlockIdentifier(int majorId, int minorId) {
        this.majorId = majorId;
        this.minorId = minorId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getMinorId() {
        return minorId;
    }

    public void setMinorId(int minorId) {
        this.minorId = minorId;
    }
}
