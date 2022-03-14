import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        for (String str : s.split("")) {
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stack.add(str);
            }
            else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                else {
                    // String st = stack.peek();
                    if (str.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    }
                    else if (str.equals("}") && stack.peek().equals("{")) {
                        stack.pop();
                    }
                    else if (str.equals("]") && stack.peek().equals("[")) {
                        stack.pop();
                    }
                    else {
                        answer = false;
                        break;
                    }
                }
            }
        }
        if (answer && !stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
