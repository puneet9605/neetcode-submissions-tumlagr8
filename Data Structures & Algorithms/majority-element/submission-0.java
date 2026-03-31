class Solution {
    public int majorityElement(int[] nums) {
        int curNum = 0;
        int count = 0;
        for(int i =0; i<nums.length ; i++){
            if(count==0){
                curNum = nums[i];
            }
            if(nums[i]== curNum){
                count++;
            } else  {
                count--;
            }
        }
        return curNum;
    }
}