package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;

public class ENI {
    private BigInteger a;
    private BigInteger b;
    private BigInteger c;
    private BigInteger x;
    private BigInteger y;
    private BigInteger z;
    private BigInteger m;
    private BigInteger eni;
    private int maxIterations; // if 0 than unlimited iterations, otherwise the max iterations to calculate ENIs

    public ENI(BigInteger a, BigInteger b, BigInteger c, BigInteger x, BigInteger y, BigInteger z, BigInteger m) {
        this(a,b,c,x,y,z,m,0);
    }

    public ENI(BigInteger a, BigInteger b, BigInteger c, BigInteger x, BigInteger y, BigInteger z, BigInteger m, int maxIterations) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.m = m;
        this.maxIterations = maxIterations;
    this.calcEni(this.a, this.b, this.c, this.x, this.y, this.z, this.m);
    }

    private void calcEni(BigInteger a, BigInteger b, BigInteger c, BigInteger x, BigInteger y, BigInteger z, BigInteger m) {
        System.out.println("Calculating ENI for: " + this.toString());
        BigInteger res1 = this.calcSingleEni(a, x, m);
        BigInteger res2 = this.calcSingleEni(b, y, m);
        BigInteger res3 = this.calcSingleEni(c, z, m);
        this.eni = this.calcSingleEni(a, x, m).add(this.calcSingleEni(b, y, m)).add(this.calcSingleEni(c, z, m));
    }

    private BigInteger calcSingleEni(BigInteger n, BigInteger e, BigInteger m) {
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(e) < 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(n).mod(m);
            if (this.maxIterations > 0 && factors.size() == this.maxIterations) {
                factors.remove(0); // remove the oldest element to keep size constant
            }
            factors.add(res);
        }
        System.out.println("Factors: " + factors);
        return this.listToBigInteger(factors);
    }

    private BigInteger listToBigInteger(ArrayList<BigInteger> list) {
        Collections.reverse(list); // revert to original order
        StringBuilder sb = new StringBuilder();
        for (BigInteger digitGroup : list) {
            sb.append(digitGroup.toString());
        }        
        return new BigInteger(sb.toString());
    }

    public BigInteger getEni() {
        return eni;
    }

    public String toString() {
        return "ENI{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", m=" + m +
                ", eni=" + eni +
                '}';
    }
}