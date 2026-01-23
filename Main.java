import algoritmia.Part1;
import exercism.bowling.BowlingGame;
import exercism.bowling.Frame;

class Main {
    public static void main(String[] args) {
        System.out.println("== Bowling Game ==");

        int[] test1 = {1,9,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] test2 = {4,3,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] test3 = {8,2,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] test4 = {7,3,4,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] test5 = {6,4,7,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        BowlingGame[] bgs = new BowlingGame[5];
        for (int x = 0; x < 5; x++) bgs[x] = new BowlingGame();

        for (int i = 0; i < 5; i++){
            BowlingGame bg = new BowlingGame();
            int[] tests = switch (i) {
                case 0 -> test1;
                case 1 -> test2;
                case 2 -> test3;
                case 3 -> test4;
                case 4 -> test5;
                default -> new int[10];
            };
            for (int d: tests){
                bgs[i].roll(d);
            }
            System.out.println(bgs[i]);
            System.out.println(bgs[i].score());
        }


    }
}