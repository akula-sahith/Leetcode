class Solution {
   public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from stack until we find a warmer temperature or the stack is empty
        while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            
            // If stack is not empty, the top of the stack is the next warmer day
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }
            
            // Push current day's index onto the stack
            stack.push(i);
        }

        return answer;
    }
}