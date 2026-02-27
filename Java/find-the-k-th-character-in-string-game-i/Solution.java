class Solution {
    public char kthCharacter(int k) {
        
        StringBuilder word = new StringBuilder("a");
        
        while (word.length() < k) {
            
            StringBuilder next = new StringBuilder();
            
            for (int i = 0; i < word.length(); i++) {
                next.append((char)(word.charAt(i) + 1));
            }
            
            word.append(next);
        }
        
        return word.charAt(k - 1);
    }
}