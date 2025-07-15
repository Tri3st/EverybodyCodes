package utils;
import java.util.ArrayList;
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

    public ENI(int a, int b, int c, int x, int y, int z, int m) {
        this.a = BigInteger.valueOf(a);
        this.b = BigInteger.valueOf(b);
        this.c = BigInteger.valueOf(c);
        this.x = BigInteger.valueOf(x);
        this.y = BigInteger.valueOf(y);
        this.z = BigInteger.valueOf(z);
        this.m = BigInteger.valueOf(m);
        this.calcEni(this.a, this.b, this.c, this.x, this.y, this.z, this.m);
    }

    private void calcEni(BigInteger a, BigInteger b, BigInteger c, BigInteger x, BigInteger y, BigInteger z, BigInteger m) {
        this.eni = this.calcSingleEni(a, x, m).add(this.calcSingleEni(b, y, m)).add(this.calcSingleEni(c, z, m));
    }

    private BigInteger calcSingleEni(BigInteger n, BigInteger e, BigInteger m) {
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(n.add(BigInteger.ONE)) < 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(n).mod(m);
            factors.add(res);
        }
        return this.listToInt(factors);
    }

    private BigInteger listToInt(ArrayList<BigInteger> list) {
        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i < list.size(); i++) {
            int power = list.size() - i - 1;
            BigInteger factor = BigInteger.TEN.pow(power).multiply(list.get(i));
            res = res.add(factor);
        }
        return res;
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