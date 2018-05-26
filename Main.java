import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = -1;
            Scanner scanner = new Scanner(System.in);
            while (n < 2) {
                System.out.print("n = ");
                n = scanner.nextInt();
            }
        } else { n = Integer.parseInt(args[0]); }

        Ring r = new Ring(n);

        r.wyznaczOdwracalne();
        r.wyznaczDzielniki();
        r.wyznaczNil();
        r.wyznaczId();

        System.out.println("elementy odwracalne (" + r.odwracalne.size() + "):");
        for (int i: r.odwracalne) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("dzielniki zera (" + r.dzielniki.size() + "):");
        for (int i: r.dzielniki) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("elementy nilpotentne (" + r.nilpotentne.size() + "):");
        for (int i: r.nilpotentne) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("elementy idempotentne (" + r.idempotentne.size() + "):");
        for (int i: r.idempotentne) {
            System.out.print(i + ", ");
        }
    }
}
