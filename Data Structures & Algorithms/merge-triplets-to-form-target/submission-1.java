class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean found0 = false;
        boolean found1 = false;
        boolean found2 = false;

        for (int[] t : triplets) {
        if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
        if (t[0] == target[0]) found0 = true;
        if (t[1] == target[1]) found1 = true;
        if (t[2] == target[2]) found2 = true;
    }
    }
    return found0==true && found1==true && found2==true;
    }
    
}
