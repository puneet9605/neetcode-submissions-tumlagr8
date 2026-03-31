class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int max1 = nums[0];
        int max2 = Math.max(nums[1], nums[0]);
        for(int i =2; i<nums.length-1; i++){
            int temp = max2;
            max2 = Math.max(max1+nums[i], max2);
            max1 = temp;
        }
        int maxWithFirst = max2;
        max1 = nums[1];
        max2 = Math.max(nums[1], nums[2]);
        for(int i =3; i<nums.length; i++){
            int temp = max2;
            max2 = Math.max(max1+nums[i], max2);
            max1 = temp;
        }
        return Math.max(maxWithFirst, max2);

    }
}
