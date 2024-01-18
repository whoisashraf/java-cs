
import java.util.*;
import java.util.stream.IntStream;

public class HelloWorld {
    // read input with scanners
    static Scanner sc = new Scanner(System.in);
    // constants use the final keyword
    final String my = "me";

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int me = 9;
        boolean happy = true;
        char a = 'a';
        float fnum = 9.0f;
        double dnum = 9.0;
        // System.out.println(fnum + dnum);
        double bnum = 1e+3;
        // System.out.println(bnum);
        long lnum = (long) (1e+20);
        // System.out.println(lnum);

        // System.out.println(Math.random());
        // string builder
        StringBuilder sr = new StringBuilder("I'm a string?");
        // System.out.println(sr.length());
        // System.out.println(sr.capacity());
        sr.append(" Me");
        // System.out.println(sr);

        // arrays!
        int[] a1 = new int[20];
        a1[2] = 77;
        Arrays.fill(a1, 2);
        // System.out.println(a1[0]);
        // System.out.println(a1.length);
        String[] a2 = { "1", "2", "3" };
        // System.out.println(a2[0]);
        int[] one_to_ten = IntStream.rangeClosed(1, 10).toArray();
        for (int x : one_to_ten) {
            System.out.println(x);
        }

        System.out.println(Arrays.binarySearch(one_to_ten, 9));
    }
}
