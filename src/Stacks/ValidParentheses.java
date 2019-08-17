package Stacks;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

 */
public class ValidParentheses {

    public static void main(String args[]) {
        String str = "([)]";
        System.out.println(isValidParentheses(str));
        System.out.println(isValidParentheses1(str));
    }

    public static boolean isValidParentheses(String str) {
        Stack<Character> charsStack = new Stack<>();

        for(char ch: str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                charsStack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                //ch need to match with top of stack element
                if (!charsStack.isEmpty() && isPairParentheses(charsStack.peek(), ch)) {
                    charsStack.pop();
                } else {
                    return false;
                }
            }
        }
        return charsStack.isEmpty();
    }

    private static boolean isPairParentheses(char left, char right) {
        return left == '{' && right == '}' || left == '[' && right == ']' || left == '(' && right == ')';
    }


    public static boolean isValidParentheses1(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else if (ch == '[') {
                stack.push(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
