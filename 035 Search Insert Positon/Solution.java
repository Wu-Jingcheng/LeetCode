class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target)
                return i;
        }
        return nums.length;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,5,6};
        int target1 = 5, target2 = 2, target3 = 7, target4 = 0;
        System.out.println(s.searchInsert(nums, target1));
        System.out.println(s.searchInsert(nums, target2));
        System.out.println(s.searchInsert(nums, target3));
        System.out.println(s.searchInsert(nums, target4)); 
    }
}