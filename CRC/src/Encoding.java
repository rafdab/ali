import java.util.ArrayList;

public class Encoding {
    private ArrayList<Integer> fcs;

    public Encoding(String args) {
        ArrayList<Byte> message = new ArrayList<>();
        ArrayList<Integer> g = new ArrayList<>();
        fcs = new ArrayList<>();
        Polynomials poly = new Polynomials(2);

        for (int i = 0; i < args.length(); ++i){
            message.add((byte)args.charAt(i));
        }
        for (int i = 0; i < 16; ++i){
            if (i == 12 || i == 5 || i==0){
                g.add(1);
            } else{
                g.add(0);
            }
        }
        g.add(1);

        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<Integer> tmp2 = new ArrayList<>();

        for (int i = 0; i < 16 ; ++i){
            tmp.add(0);
        }
        for (byte b : message){
            String s2 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            for (int i = 0; i < 8; ++i){
                tmp.add(Character.getNumericValue(s2.charAt(i)));
            }
        }
        for (int i = 0; i < args.length(); ++i) tmp2.add(0);
        for (int i = 0; i < 16; ++i) tmp2.add(1);

        fcs = poly.divModN(poly.add(tmp, tmp2), g);
        while(fcs.size() < 16) fcs.add(0);
    }

    public ArrayList<Integer> getFcs() {
        return fcs;
    }

    public String getFcsChars(){
        int a = 0;
        int b = 0;
        for (int i = 0; i < 8; ++i){
            if (fcs.get(i) == 1){
                a += Math.pow(2, 7-i);
            }
            if (fcs.get(i + 8) == 1){
                b += Math.pow(2, 7-i);
            }
        }
        return Character.toString((char)a) + Character.toString((char)b);
    }
}