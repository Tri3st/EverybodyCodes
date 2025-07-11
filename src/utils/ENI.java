package utils;

import java.util.ArrayList;
import java.util.Collections;

public class ENI {
    private int a;
    private int b;
    private int c;
    private int x;
    private int y;
    private int z;
    private int m;
    private int total = 0;

    public ENI(String vars) {
        String[] enis = vars.split(" ");
        for (String eni : enis) {
            switch (Character.toLowerCase(eni.charAt(0))) {
                case 'a':
                    a = Integer.parseInt(eni.substring(2));
                    break;
                case 'b':
                    b = Integer.parseInt(eni.substring(2));
                    break;
                case 'c':
                    c = Integer.parseInt(eni.substring(2));
                    break;
                case 'x':
                    x = Integer.parseInt(eni.substring(2));
                    break;
                case 'y':
                    y = Integer.parseInt(eni.substring(2));
                    break;
                case 'z':
                    z = Integer.parseInt(eni.substring(2));
                    break;
                case 'm':
                    m = Integer.parseInt(eni.substring(2));
                    break;
            }
        }
        this.total += this.calcEni(a,x,m);
        this.total += this.calcEni(b,y,m);
        this.total += this.calcEni(c,z,m);
    }

    /**
     * Overloaded calcENi functions that also takes a max length. Only shows the last maxLength numbers
     * @param n int N
     * @param e int Exp
     * @param m int Mod
     * @param maxLength int Maximum length of the array
     * @return Returns the ENI
     */
    private int calcEni(int n, int e, int m, int maxLength) {
        int tmp = 1;
        ArrayList<Integer> tmparr = new ArrayList<>();
        for (int i = 0; i < e; i++){
            tmp = (tmp * n) % m;
            tmparr.add(tmp);
            if (tmparr.size() > maxLength){
                tmparr.remove(0);
            }
        }
        Collections.reverse(tmparr);
        int[] intArr = new int[tmparr.size()];
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
    private int calcEni(int n, int e, int m) {
        int tmp = 1;
        ArrayList<Integer> tmparr = new ArrayList<>();
        for (int i = 0; i < e; i++){
            tmp = (tmp * n) % m;
            tmparr.add(tmp);
        }
        Collections.reverse(tmparr);
        int[] intArr = new int[tmparr.size()];
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
    private int arrayToInteger(int[] arr){
        int total = 0;
        if (arr.length < 1) return -1;
        else if (arr.length == 1) return arr[0];
        else {
            for (int i = arr.length - 1; i > -1; i--) {
                int exp = arr.length - i - 1;
                total += arr[i] * (int) Math.pow((double) 10, (double)exp);
            }
        }
        return total;
    }

    public int getTotal(){
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
