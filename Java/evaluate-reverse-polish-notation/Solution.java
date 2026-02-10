class Solution {
    public int evalRPN(String[] tokens) {
        return evaluate(tokens);
    }

    //Evaluate the tokens
    public int evaluate(String[] tokens){
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<tokens.length;i++){


           if(tokens[i].equals("+") || 
              tokens[i].equals("*") || 
              tokens[i].equals("/") || 
              tokens[i].equals("-")){

                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                int ans = 0;
                if(tokens[i].equals("+")){
                   ans = first + second;
                }else if(tokens[i].equals("*")){
                   ans = first * second;
                }else if(tokens[i].equals("/")){
                   ans = second / first;
                }else{
                   ans = second - first;
                }
                stack.push(Integer.toString(ans));
            }else{
                stack.push(tokens[i]);
            }


        }
        return Integer.parseInt(stack.pop());
    }
}