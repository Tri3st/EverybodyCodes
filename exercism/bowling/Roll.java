package exercism.bowling;

public class Roll {
    private int pins;

    public Roll() {
        this.pins = 0;
    }

    public void roll(int pins) {
        this.pins = pins;
    }

    public int getRoll(){
        return this.pins;
    }

    public String toString(){
        return " " + this.pins + " ";
    }
}
