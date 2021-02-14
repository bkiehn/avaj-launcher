package shool21;

public enum AirCraftType {
    BALLOON ("shool21.Baloon"),
    HELICOPTER ("shool21.Helicopter"),
    JETPLANE ("shool21.JetPlane");

    private final String type;

    AirCraftType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
