import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int mod = Integer.parseInt(args[0]);
        ArrayList<Integer> f = new ArrayList<>();
        args[1] = args[1].substring(1,args[1].length()-1);
        String[] tmpStrings = args[1].split(",");
        for (String s : tmpStrings) f.add(Integer.parseInt(s));
        PolynomialRings pr = new PolynomialRings(mod, f);

        pr.print(pr.inv());
        pr.print(pr.zeroDivisors());
        pr.print(pr.nil());
        pr.print(pr.id());
    }
}