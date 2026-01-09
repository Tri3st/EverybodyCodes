package ducksndragons.quest2;

public class Complex {
    private long x;
    private long y;

    public Complex(long x, long y) {
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

    /**
     * Initialize the Complex with given x and y
     * @param x The x
     * @param y The y
     */
    public void setComplex(long x, long y){
        this.x = x;
        this.y = y;
    }

    public Complex copyComplex() {
        return new Complex(this.x, this.y);
    }

    public long getX() {
        return x;
    }

    public long getY() {
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
        long x = this.x + c.getX();
        long y = this.y + c.getY();
        return new Complex(x, y);
    }

    /**
     * [X1,Y1] * [X2,Y2] = [X1 * X2 - Y1 * Y2, X1 * Y2 + Y1 * X2]
     * where X1 = this.x1 and X2 is the x that is sent as parameter
     * @param c Complex(x2,y2)
     * @return Complex number with the calculation done
     */
    public Complex multiplyComplex(Complex c){
        long x = this.x * c.getX() - this.y * c.getY();
        long y = this.x * c.getY() + this.y * c.getX();
        return new Complex(x, y);
    }

    /**
     * [X1,Y1] / [X2,Y2] = [X1 / X2, Y1 / Y2]
     * where X1 = this.x1 and X2 is the x that is sent as parameter
     * @param c Complex(x2,y2)
     * @return Complex number with the calculation done
     */
    public Complex divideComplex(Complex c){
        long x = 0;
        long y = 0;
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
