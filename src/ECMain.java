import quest1.Quest1;

public class ECMain {
    public static void main(String[] args) {
        System.out.println("Everybody Codes");

        Quest1 q1 = new Quest1(1,0);
        System.out.println("Total from sample notes : " + q1.getTotal(1));
        System.out.println("The highest from the sample notes : " + q1.getHighest(1));

        Quest1 q2 = new Quest1(1, 1);
        System.out.println("Total from notes file : " + q2.getTotal(1));
        System.out.println("The highest from the notes file : " + q2.getHighest(1));


        Quest1 q3 = new Quest1(2,0);
        System.out.println("Total from sample notes : " + q3.getTotal(2));
        System.out.println("The highest from the sample notes : " + q3.getHighest(2));

//        Quest1 q4 = new Quest1(2, 1);
//        System.out.println("Total from notes file : " + q4.getTotal());
//        System.out.println("The highest from the notes file : " + q4.getHighest());
    }
}
