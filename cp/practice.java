public class practice {

    public static void main(String[] args) {
        // Exception handling in java using try catch

        // will cause an exception!
        // try {
        // int myInt = Integer.parseInt("20");
        // System.out.println(myInt);
        // } catch (NumberFormatException e) {
        // System.out.println("You can' t make an integer out of that!");
        // } finally {
        // System.out.println("Always executed!");
        // }

        // do while loops(runs at least once as it does the do block before checking the
        // condition)
        // int i = 11;
        // do {
        // System.out.println(i);
        // i++;
        // } while (i<=10);

        // checks the condition before running any statements
        // int n = 11;
        // while (n <= 10) {
        // System.out.println(n);
        // n++;
        // }

        // break and continue in loops
        // for (int index = 0; index <= 100; index++) {
        // if (index % 2 == 0) {
        // // on reaching continue, the body doesn't run but the condition is re-run
        // just like the loop
        // continue;
        // }
        // System.out.println(index);
        // }

        // for (int index = 0; index <= 100; index++) {
        // if (index % 2 == 0) {
        // // on reaching break, the body doesn't run and the whole loop
        // break;
        // }
        // System.out.println(index);
        // }

        // for (int i = 1; i <= 3; i++) {
        // // System.out.println("i is: "+i);
        // for (int j = 1; j <= 3; j++) {
        // // System.out.println("j is: "+j);
        // if (i == j)
        // continue;

        // System.out.println(i + j + " ");

        // }

        // }

        // int i = 0;

        // outer:

        // while (i < 5) {

        //     inner:

        //     for (int j = 0; j < 3; j++) {

        //         if (i == 3)

        //             break outer;

        //         if (j == 2)

        //             continue inner;

        //         System.out.print(i + j + " ");

        //     }

        //     i++;

        // }

        int day = 1;
        if (day == 1) {
            System.out.println("Monday!");
       } else if (day == 2) {
           System.out.println("Tuesday!");
       } 
        

    }

}
