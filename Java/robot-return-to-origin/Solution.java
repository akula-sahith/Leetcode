class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for(int i = 0 ; i < moves.length() ; i++){
           if(moves.charAt(i)=='U'){
              x += (+1);
           }else if(moves.charAt(i)=='D'){
              x += (-1);
           }else if(moves.charAt(i)=='L'){
            y += (-1);
           }else{
            y += (+1);
           }
        }

        return x==0&&y==0;
    }
}