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
        System.out.println("Calculating ENI for: " + this.toString());
        BigInteger res1 = this.calcSingleEni(a, x, m);
        BigInteger res2 = this.calcSingleEni(b, y, m);
        BigInteger res3 = this.calcSingleEni(c, z, m);
        System.out.println("a: %s x: %s m: %s -> %s".formatted(a, x, m, res1.toString(10)));
        System.out.println("b: %s y: %s m: %s -> %s".formatted(b, y, m, res2.toString(10)));
        System.out.println("c: %s z: %s m: %s -> %s".formatted(c, z, m, res3.toString(10)));
        System.out.println("Final ENI: %s".formatted(res1.add(res2).add(res3).toString(10)));
        this.eni = this.calcSingleEni(a, x, m).add(this.calcSingleEni(b, y, m)).add(this.calcSingleEni(c, z, m));
    }

    private BigInteger calcSingleEni(BigInteger n, BigInteger e, BigInteger m) {
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(e) < 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(n).mod(m);
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