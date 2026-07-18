package Questions;

import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("(((()"));
    }

    public static int minAddToMakeValid(String s){
        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty() && ch == ')'){
                    stack.pop();
                }
                else{
                    return 0;
                }
            }
        }
        return stack.size();
    }
}