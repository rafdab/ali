import java.util.ArrayList;

public class PolynomialRings {
    private int mod;
    private ArrayList<Integer> func;
    private Polynomials poly;
    private ArrayList<ArrayList<Integer>> elements;

    public PolynomialRings(int mod, ArrayList<Integer> func) {
        this.mod = mod;
        this.func = func;
        this.poly = new Polynomials(mod);
        populate();
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

    public void print(ArrayList<ArrayList<Integer>> tmp) {
        System.out.print("[");
        for (int i = 0; i < tmp.size(); ++i){
            System.out.print("[");
            for (int j = 0; j < tmp.get(i).size(); ++j){
                if (j < tmp.get(i).size() - 1) System.out.print(tmp.get(i).get(j) + ", ");
                else System.out.print(tmp.get(i).get(j));
            }
            if (i < tmp.size() - 1) System.out.print("], ");
            else System.out.print("]");
        }
        System.out.println("]");
    }

    private void populate(){
        elements = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        int i = 0;

        while (result.size() < func.size()){
            elements.add(new ArrayList<>(result));
            i = (i + 1) % mod;
            result.set(0, i);
            if (i == 0){
                if (result.size() == 1){
                    result.add(1);
                }else {
                    int tmp = (result.get(1) + 1);
                    result.set(1, tmp);

                    for (int k = 1; k < result.size(); ++k){
                        if (result.get(k) == 0 || result.get(k) % mod != 0) break;
                        tmp = (result.get(k)) % mod;
                        result.set(k, 0);
                        if (tmp == 0){
                            if (k + 1 < result.size()){
                                tmp = (result.get(k + 1) + 1);
                                result.set(k + 1, tmp);
                            } else {
                                result.add(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> inv(){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> check = new ArrayList<>();
        ArrayList<Integer> tmp;
        check.add(1);
        for (ArrayList<Integer> a : elements){
            if (check.equals(a)) result.add(new ArrayList<>(a));
            try {
                tmp = normalize(poly.gcc(a, func));
                if (check.equals(tmp)) result.add(new ArrayList<>(a));
            }catch (Exception e){
                // noop;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> zeroDivisors(){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tmp;
        for (ArrayList<Integer> a : elements){
            for (ArrayList<Integer> b : elements){
                tmp = normalize(poly.divModN(poly.multiply(a, b), func));
                if(tmp.size() == 0){
                    result.add(new ArrayList<>(a));
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> nil(){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        return result;
    }

    public ArrayList<ArrayList<Integer>> id(){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        return result;
    }
}