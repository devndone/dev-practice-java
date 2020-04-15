package practice.dev.problemsolving;

public class BinaryStringCombinationsRecursiveByDev {

    public static void main(String[] args) {
        String in = "1??0?101";
        char[] inarr = in.toCharArray();
        print(inarr, 0);
    }

    public static void print(char[] inarr, int index) {
        if(inarr.length == index) {
            System.out.println(inarr);
            return;
        }
        if(inarr[index] == '?') {
            inarr[index] = '0';
            print(inarr, index + 1);
            inarr[index] = '1';
            print(inarr, index + 1);
            inarr[index] = '?';
        } else {
            print(inarr, index + 1);
        }
    }

}
