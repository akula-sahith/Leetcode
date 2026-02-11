class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
           char present = s.charAt(i);
           if(stack.isEmpty() ||
               present == '{' ||
               present == '[' ||
               present == '('){
              stack.add(s.charAt(i));
           }else{
              char check = stack.peek();
              if(present==')' && check=='('){
                stack.pop();
              }else if(present==']' && check=='['){
                stack.pop();
              }else if(present=='}' && check=='{'){
                stack.pop();
              }else{
                stack.add(present);
              }
           }
        }

        return stack.isEmpty();
    }
}