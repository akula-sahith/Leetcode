class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int max_vowels = Integer.MIN_VALUE;
        int vowel_count = 0;
        for(int i = 0 ; i < k ; i++){
            if(vowels.contains(s.charAt(i))){
                vowel_count++;
            }
        }

        max_vowels = vowel_count;
        int left = 0;

        for(int i = (k);i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                vowel_count++;
            }
            if(vowels.contains(s.charAt(left))){
                vowel_count--;
            }
            left++;
            max_vowels = Math.max(max_vowels , vowel_count);
        }

        return max_vowels;
    }
}