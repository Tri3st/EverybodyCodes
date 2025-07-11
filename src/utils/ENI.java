package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ENI {
    private long a;
    private long b;
    private long c;
    private long x;
    private long y;
    private long z;
    private long m;
    private long total = 0;

    public ENI(String vars, int maxLength) {
        Pattern pattern = Pattern.compile("A=(?<a>\\d+) B=(?<b>\\d+) C=(?<c>\\d+) X=(?<x>\\d+) Y=(?<y>\\d+) Z=(?<z>\\d+) M=(?<m>\\d+)");
        Matcher matcher = pattern.matcher(vars);
        if(matcher.find()){
            this.a = Long.parseLong(matcher.group("a"));
            this.b = Long.parseLong(matcher.group("b"));
            this.c = Long.parseLong(matcher.group("c"));
            this.x = Long.parseLong(matcher.group("x"));
            this.y = Long.parseLong(matcher.group("y"));
            this.z = Long.parseLong(matcher.group("z"));
            this.m = Long.parseLong(matcher.group("m"));
        }
        if (maxLength > 0){
            this.total += this.calcEni(a,x,m,maxLength);
            this.total += this.calcEni(b,y,m,maxLength);
            this.total += this.calcEni(c,z,m,maxLength);
        } else {
            this.total += this.calcEni(a,x,m);
            this.total += this.calcEni(b,y,m);
            this.total += this.calcEni(c,z,m);
        }

    }

    /**
     * Overloaded calcENi functions that also takes a max length. Only shows the last maxLength numbers
     * @param n int N
     * @param e int Exp
     * @param m int Mod
     * @param maxLength int Maximum length of the array
     * @return Returns the ENI
     */
    private long calcEni(long n, long e, long m, long maxLength) {
        long tmp = 1;
        ArrayList<Long> tmparr = new ArrayList<>();
        for (int i = 0; i < e; i++){
            tmp = (tmp * n) % m;
            tmparr.add(tmp);
            if (tmparr.size() > maxLength){
                tmparr.remove(0);
            }
        }
        Collections.reverse(tmparr);
        long[] intArr = new long[tmparr.size()];
        for(int i = 0; i < tmparr.size(); i++) {
            intArr[i] = tmparr.get(i);
        }
        return this.arrayToInteger(intArr);
    }

    /**
     * calcEni calculates the ENI of the given N, exp and mod.
     *
     * @param n int N
     * @param e int Exp
     * @param m int Mod
     * @return ENI of the given parameters
     */
    private long calcEni(long n, long e, long m) {
        long tmp = 1;
        ArrayList<Long> tmparr = new ArrayList<>();
        for (long i = 0; i < e; i++){
            tmp = (tmp * n) % m;
            tmparr.add(tmp);
        }
        Collections.reverse(tmparr);
        long[] intArr = new long[tmparr.size()];
        for(int i = 0; i < tmparr.size(); i++) {
            intArr[i] = tmparr.get(i);
        }
        return this.arrayToInteger(intArr);
    }

    /**
     * arrToInteger return the integer value of an array of integers.
     * [1,2,3,4] becomes 1234. The 4 being the ones, the 3 the tens, etc.
     *
     * @param arr array of integers
     * @return the integer representation of the array
     */
    private long arrayToInteger(long[] arr){
        String tmp = "";
        for (long n: arr){
            tmp += "" + n;
        }
        return Long.parseLong(tmp);
    }

    public long getTotal(){
        return this.total;
    }

    public String toString(){
        String tmp = "";
        tmp += "eni(" + this.a + "," + this.x + "," + this.m + ") + eni(" + this.b + "," + this.y + "," + this.m;
        tmp += ") + eni(" + this.z + "," + this.c + "," + this.m + ") = " + this.calcEni(this.a,this.x,this.m) + " + ";
        tmp += this.calcEni(this.b,this.y,this.m) + " + " + this.calcEni(this.c,this.z,this.m) + " = " + this.total;
        return tmp;
    }
}
