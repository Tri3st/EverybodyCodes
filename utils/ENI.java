class ENI {
    private final String EXAMPLE1 = """
A=4 B=4 C=6 X=3 Y=4 Z=5 M=11
A=8 B=4 C=7 X=8 Y=4 Z=6 M=12
A=2 B=8 C=6 X=2 Y=4 Z=5 M=13
A=5 B=9 C=6 X=8 Y=6 Z=8 M=14
A=5 B=9 C=7 X=6 Y=6 Z=8 M=15
A=8 B=8 C=8 X=6 Y=9 Z=6 M=16""";
    private String final EXAMPLE2 = """

    """;
    private int a;
    private int b;
    private int c;
    private int x;
    private int y;
    private int z;
    private int m;
    private int eni;

    public ENI(int a, int b, int c, int x, int y, int z, int m) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.m = m;
        this.calcEni(a,b,c,x,y,z,m);
    }

    private void calcEni(int a, int b, int c, int x, int y, int z, int m) {
        this.eni = this.calcSingleEni(a, x, m) + this.calcSingleEni(b, y, m) + this.calcSingleEni(c, z, m);

    private void calcSingleEni(int n, int e, int m) {
        int res = 1;
        for (int i = 0; i < n + 1; i++) {
            res = (res * n) % m;
        }
        return res;
    }

    public int getEni() {
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