package ducksndragons.quest2;

public class Engraving {
    private boolean engrave;
    private Complex p;
    private Complex result;
    private int cycles;

    public Engraving(Complex p, Complex result, int cycles) {
        this.p = p;
        this.result = result;
        this.cycles = cycles;
        if (Math.abs(this.result.getX()) > 1_000_000 || Math.abs(this.result.getY()) > 1_000_000){
            this.engrave = false;
        }
    }

    public Complex getResult() {
        return this.result;
    }

    public Complex getP() {
        return this.p;
    }

    public int getCycles(){
        return this.cycles;
    }

    public boolean isEngrave(){
        return this.engrave;
    }

    @Override
    public String toString() {
        return "Engraving{" +
                "engrave=" + engrave +
                ", p=" + p +
                ", result=" + result +
                ", cycles=" + cycles +
                '}';
    }
}
