class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            if(i>max){
                max = i;
            }
        }
        int start = 1;
        while(start<=max){
            int remainTime = h;
            int mid = (start+max)/2;
            boolean canClear = true;
            for(int i: piles) {
                remainTime -= (i+mid-1)/mid;
                if(remainTime<0) {
                    canClear = false;
                    break;
                }
            }
            if (canClear == false){
                start = mid+1;
            }else{
                max = mid-1;
            }

            
        }
        return start;
        
    }
}
