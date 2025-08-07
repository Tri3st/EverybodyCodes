public enum Border {
    NONE(0), 
    TOP(1), 
    RIGHT(2), 
    BOTTOM(3), 
    LEFT(4);

    private final int value;

    Border(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Border fromValue(int value) {
        for (Border border : Border.values()) {
            if (border.getValue() == value) {
                return border;
            }
        }
        throw new IllegalArgumentException("Invalid border value: " + value);
    }
}   