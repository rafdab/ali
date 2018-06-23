import java.util.ArrayList;

public class PolynomialRings {
    private int mod;
    private ArrayList<Integer> func;

    public PolynomialRings(int mod, ArrayList<Integer> func) {
        this.mod = mod;
        this.func = func;
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

    public ArrayList<Integer> invesibles(){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < func.size(); ++i){
            if (result.size() < func.size())
            for (int posA = 0; posA <= i; ++posA){
                if (result.size() < posA + 1) result.add(0);
                for (int tmp = 0; tmp < posA; ++tmp) result.set(tmp, 0); //zeroing
                for (int posB = 0; posB <= posA; ++posB){
                    for (int val = 0; val < mod; ++val){

                    }
                }
            }
        }

        return normalize(result);
    }
}
