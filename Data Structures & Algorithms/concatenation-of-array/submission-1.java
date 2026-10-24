class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] newList = new int[nums.length*2];
        for(int i = 0 ; i<nums.length; i++){
            newList[i]=nums[i];
            newList[i+nums.length] = nums[i];
        }
        return newList;
    }
}