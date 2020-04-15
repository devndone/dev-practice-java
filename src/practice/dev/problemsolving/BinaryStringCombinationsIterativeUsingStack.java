package practice.dev.problemsolving;

import java.util.Stack;

public class BinaryStringCombinationsIterativeUsingStack {

    static Stack<Data> stack = new Stack<>();

    public static void main(String[] args) {
        String input = "1?0?";
        updateStack(stack, 0, input);
        while (!stack.isEmpty()) {
            if (stack.size() == input.length()) {
                System.out.println(stack.toString());
            }
            Data d = stack.pop();
            if (d.questionMark && d.currentValue == '0') {
                stack.push(new Data(true, '1'));
                if (stack.size()-1 < (input.length() - 1)) {
                    updateStack(stack, stack.size() , input);
                }
            }
        }
    }

    public static void updateStack(Stack stack, int start, String input) {
        for (int i = start; i < input.length(); i++) {
            if (input.charAt(i) == '?') {
                stack.push(new Data(true, '0'));
            } else {
                stack.push(new Data(false, input.charAt(i)));
            }
        }
    }

    static class Data {
        boolean questionMark;
        char currentValue;

        public Data(boolean isQuestionMark, char currentValue) {
            questionMark = isQuestionMark;
            this.currentValue = currentValue;
        }

        @Override
        public String toString() {
            return Character.toString(currentValue);
        }
    }
}
