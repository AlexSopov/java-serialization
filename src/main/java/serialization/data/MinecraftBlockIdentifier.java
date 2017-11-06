package serialization.data;

public class MinecraftBlockIdentifier {
    private int majorId;
    private int minorId;

    public MinecraftBlockIdentifier() {
        this(0, 0);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MinecraftBlockIdentifier)) {
            return false;
        }

        MinecraftBlockIdentifier that = (MinecraftBlockIdentifier) o;

        return majorId == that.majorId && minorId == that.minorId;
    }
}
