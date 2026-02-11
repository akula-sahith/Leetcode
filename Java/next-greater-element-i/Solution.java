class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return findSolution(nums1,nums2);
    }

    //Using monotonic stack approach - O(n)
    public int[] findSolution(int[] nums1,int[] nums2){
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = nums2.length - 1;i>=0;i--){

            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }

            int nextGreater = stack.isEmpty() ? -1 : stack.peek();

            map.put(nums2[i],nextGreater);

            stack.push(nums2[i]);
        }

        for(int i = 0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;

    }
}