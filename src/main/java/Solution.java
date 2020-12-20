import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static String removeDuplicateLetters(String s) {
        // 单调栈
        Stack<Character> stack = new Stack();
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            // 遍历
            if (!stack.contains(cs[i])) {
                // stack 不为空 && 栈顶元素大于当前元素 && 后面还会出现这个元素
                while (!stack.isEmpty() && stack.peek() > cs[i] && s.substring(i).contains(stack.peek() + "")) {
                    stack.pop();
                }
                stack.add(cs[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Impl impl = new Impl();
        impl.print();
    }
}


