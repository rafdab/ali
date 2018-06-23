import java.util.ArrayList;

public class Polynomials {
    int n;

    public Polynomials(int n) {
        this.n = n;
    }

    private ArrayList<Integer> normalize(ArrayList<Integer> w){
        for (int i = w.size()-1; i >= 0; --i){
            if (w.get(i).equals(0)) {
                w.remove(i);
            }else {
                return w;
            }
        }
        return w;
    }

    public ArrayList<Integer> multiply(ArrayList<Integer> f, ArrayList<Integer> g){
        ArrayList<Integer> result = new ArrayList<>();
        int tmp;

        for (int i = 0; i < f.size(); ++i){
            for (int j = 0; j < g.size(); ++j){
                tmp = f.get(i) * g.get(j);
                if (i + j < result.size()){
                    tmp += result.get(i+j);
                    result.set(i + j, tmp % n);
                } else {
                    while ((i + j) >= (result.size())){
                        result.add(0);
                    }
                    result.set(i + j, tmp % n);
                }
            }
        }
        return normalize(result);
    }

    private int getZero(int a, int b) throws ArithmeticException{
        for (int i = 0; i <= n; ++i){
            if ((a + (-(b * i))) == 0) return i;
        }
        throw new ArithmeticException("not reversible");
    }

    public ArrayList<Integer> multiplyByConst(ArrayList<Integer> f, Integer a){
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : f){
            result.add((i * a) % n);
        }
        return result;
    }

    public ArrayList<Integer> subtract(ArrayList<Integer> f, ArrayList<Integer> g){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < f.size(); ++i){
            if (i < g.size()){
                result.add(Math.floorMod(f.get(i) - g.get(i), n));
            } else{
                result.add(f.get(i));
            }
        }
        return result;
    }

    public ArrayList<Integer> divModN(ArrayList<Integer> f, ArrayList<Integer> g) throws ArithmeticException{
        ArrayList<Integer> quotient = new ArrayList<>();
        ArrayList<Integer> remainder = new ArrayList<>(f);
        ArrayList<Integer> tmpList;
        int a = f.size() - 1;
        int b = g.size() - 1;

        for (int i = 0; i < a - b + 1; ++i){
            quotient.add(0);
        }

        int q = quotient.size()-1;
        int tmp;
        while (a >= b) {
            tmp = getZero(remainder.get(a), g.get(b));
            quotient.set(q--, tmp);
            tmpList = multiplyByConst(g, tmp);
            while(tmpList.size() <= a) tmpList.add(0,0);
            remainder = subtract(remainder, tmpList);
            --a;
        }
        return normalize(remainder);
    }

    public ArrayList<Integer> gcc (ArrayList<Integer> f, ArrayList<Integer> g){
        if (g.size() == 0) return f;
        if (f.size() > g.size()){
            return gcc(g, divModN(f, g));
        } else return gcc(g, divModN(g, f));
    }
}