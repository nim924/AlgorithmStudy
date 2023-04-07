package day0407;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calc_string {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] exp = br.readLine().replaceAll(" ", "").toCharArray();

        long result = calculate(exp);
        System.out.println(result);
    }

    public static long calculate(char[] exp) {
        Stack<Long> stack = new Stack<>();
        char op = '+';
        long num = 0;

        for (int i = 0; i < exp.length; i++) {
            char ch = exp[i];

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == exp.length - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    long prevNum = stack.pop();
                    stack.push(prevNum * num);
                }

                op = ch;
                num = 0;
            }
        }

        long result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}