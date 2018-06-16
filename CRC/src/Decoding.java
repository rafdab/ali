public class Decoding {
    private Boolean check;

    public Decoding(String arg){
//        Polynomials poly = new Polynomials(2);
//        ArrayList<Byte> message = new ArrayList<>();
//        ArrayList<Integer> g = new ArrayList<>();
//        ArrayList<Integer> l = new ArrayList<>();
//        ArrayList<Integer> tmp = new ArrayList<>();
//        ArrayList<Integer> tmp2 = new ArrayList<>();
//
//        for (int i = 0; i < arg.length(); ++i){
//            message.add((byte)arg.charAt(i));
//        }
//        for (int i = 0; i < 16; ++i){
//            if (i == 12 || i == 5 || i==0){
//                g.add(1);
//            } else{
//                g.add(0);
//            }
//            l.add(1);
//        }
//        g.add(1);
//
//        for (int i = 0; i < 16 ; ++i){
//            tmp.add(0);
//        }
//        for (byte b : message){
//            String s2 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
//            for (int i = 0; i < 8; ++i){
//                tmp.add(Character.getNumericValue(s2.charAt(i)));
//            }
//        }
//        for (int i = 0; i < arg.length() * 8; ++i) tmp2.add(0);
//        for (int i = 0; i < 16; ++i) tmp2.add(1);
//
//        tmp = poly.divModN(poly.add(tmp, tmp2),g);
//
//        if (tmp.size() == 0) {
//            check = true;
//        } else
//            check = false;

        String m = arg.substring(0, arg.length()-2);
        String fcs = arg.substring(arg.length()-2);
        Encoding e = new Encoding(m);
        if (e.getFcsChars().equals(fcs)) check = true;
        else check = false;
    }

    public Boolean getCheck() {
        return check;
    }
}