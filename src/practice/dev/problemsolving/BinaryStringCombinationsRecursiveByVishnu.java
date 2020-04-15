package practice.dev.problemsolving;

public class BinaryStringCombinationsRecursiveByVishnu {

    public static void main(String[] args) {
        String input = "01??01?";
        char[] inputArray = input.toCharArray();
        print(inputArray,0);

    }
    public static void  print(char[] s, int index) {
        if(index == s.length) {
            System.out.println(s);
            return;
        }
        for (int i = index; i< s.length;i++) {
            if(s[i] == '?') {
                s[i]='0';
                print(s, i+1);
                s[i]='1';
                print(s, i+1);
                s[i]='?';
                break;
            }
        }
    }
}