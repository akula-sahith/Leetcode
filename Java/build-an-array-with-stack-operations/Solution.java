class Solution {
    public List<String> buildArray(int[] target, int n) {
        return findStackOps(target,n);
    }

    //Brute Force ()
    public List<String> findStackOps(int[] target,int n){
        List<String> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] builded = new int[target.length];
        int h = 0;
        int i = 0;
        int k = 1;
        int un_count = 0;
        while(k<=n && i<target.length){
           if(k==target[i]){
            if(stack.isEmpty()){
               stack.push(k);
            }else{
               while(un_count>0){
                   stack.pop();
                   ans.add("Pop");
                   un_count--;
               }
               stack.push(k);
            }
            builded[h] = k;
            ans.add("Push");
            h++;
            i++;
            k++;
            if(target==builded){
                return ans;
            }
           }else{
            stack.push(k);
            ans.add("Push");
            k++;
            un_count++;
           }
        }
        return ans;
    }
}