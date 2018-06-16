import java.util.ArrayList;

public class Ring {
    int n;
    ArrayList<Integer> odwracalne;
    ArrayList<Integer> dzielniki;
    ArrayList<Integer> nilpotentne;
    ArrayList<Integer> idempotentne;

    public Ring(int n) {
        this.n = n;
        odwracalne = new ArrayList<>();
        dzielniki = new ArrayList<>();
        nilpotentne = new ArrayList<>();
        idempotentne = new ArrayList<>();
    }
    private int nwd(int a, int b){
        while (a != b){
            if (a > b) a -=b;
            else b -= a;
        }
        return a;
    }

    private int phi(int a){
        float result = a;
        for (int p = 2; p * p <= a; ++p) {
            if (a % p == 0) {
                while (a % p == 0)
                    a /= p;
                result *= (1.0 - (1.0 / (float)p));
            }
        }
        if (a > 1)
            result *= (1.0 - (1.0 / (float)a));

        return (int)result;
    }

    static int modularPower(int x, int y, int p){
        int res = 1;
        x = x % p;

        while (y > 0){
            if((y & 1)==1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    void wyznaczOdwracalne(){
        for (int i = 1; i < n; ++i){
            if (nwd(i, n) == 1) odwracalne.add(i);
        }
    }

    void wyznaczDzielniki(){
        for (int i = 1; i < n; ++i){
            for (int j = 1; j < n; ++j){
                if(((i * j) % n) == 0){
                    dzielniki.add(i);
                    break;
                }
            }
        }
    }

    void wyznaczNil(){
        for (int i = 1; i < n; ++i){
            for (int j = 1; j <= phi(n); ++j){
                if (modularPower(i, j, n) == 0){
                    nilpotentne.add(i);
                    break;
                }
            }
        }
    }

    void wyznaczId(){
        int pow;
        for (int i = 0; i < n; ++i){
            pow = (i * i) % n;
            if (pow == i){
                idempotentne.add(i);
            }
        }
    }
}
