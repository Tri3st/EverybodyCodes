package ducksndragons.quest2;

public class Complex {
    private int x;
    private int y;

    public Complex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Complex(){
        this(0, 0);
    }

    /**
     * Initialize the complex number to [0,0]
     */
    public void resetComplex(){
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * [X1,Y1] + [X2,Y2] = [X1 + X2, Y1 + Y2]
     * where X1 = this.x1 and X2 is the x that is sent as parameter
     * @param c Complex(x2,y2)
     * @return Complex number with the calculation done
     */
    public Complex addComplex(Complex c){
        // X1 = this.x
        // X2 = c.getX()
        int x = this.x + c.getX();
        int y = this.y + c.getY();
        return new Complex(x, y);
    }

    /**
     * [X1,Y1] * [X2,Y2] = [X1 * X2 - Y1 * Y2, X1 * Y2 + Y1 * X2]
     * where X1 = this.x1 and X2 is the x that is sent as parameter
     * @param c Complex(x2,y2)
     * @return Complex number with the calculation done
     */
    public Complex multiplyComplex(Complex c){
        int x = this.x * c.getX() - this.y * c.getY();
        int y = this.x * c.getY() + this.y * c.getX();
        return new Complex(x, y);
    }

    /**
     * [X1,Y1] / [X2,Y2] = [X1 / X2, Y1 / Y2]
     * where X1 = this.x1 and X2 is the x that is sent as parameter
     * @param c Complex(x2,y2)
     * @return Complex number with the calculation done
     */
    public Complex divideComplex(Complex c){

        int x = 0;
        int y = 0;
        try {
            x = this.x / c.getX();
            y = this.y / c.getY();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Complex(x, y);
    }

    @Override
    public String toString() {
        return "[%d,%d]".formatted(this.x, this.y);
    }
}
