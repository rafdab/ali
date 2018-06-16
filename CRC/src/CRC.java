public class CRC {
    public static void main(String[] args) {
        try {
            if (args[1].equals("-e")){
                Encoding tmp = new Encoding(args[0]);
                System.out.println(args[0] + tmp.getFcsChars());
            } else if (args[1].equals("-d")){
                Decoding d = new Decoding(args[0]);
                System.out.println(d.getCheck());
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Za mało argumentów");
        }
    }
}