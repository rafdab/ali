import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int mod = Integer.parseInt(args[0]);
        Polynomials poly = new Polynomials(mod);
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> g = new ArrayList<>();

        String[] tmpString = args[1].split(",");
        String[] tmpString2 = args[2].split(",");

        for (String s : tmpString){
            f.add(Integer.parseInt(s));
        }
        for (String s : tmpString2){
            g.add(Integer.parseInt(s));
        }

        System.out.print("[");
        for (int i : poly.multiply(f, g)){
            System.out.print(i + " ");
        }
        System.out.print("], [");
        for (int i : poly.divModN(f, g)){
            System.out.print(i + " ");
        }
        System.out.print("], [");
        for (int i : poly.gcc(f, g)){
            System.out.print(i + " ");
        }
        System.out.print("]");

    }
}