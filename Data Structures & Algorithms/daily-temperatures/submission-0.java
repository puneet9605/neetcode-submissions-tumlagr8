class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] res = new int[temperatures.length];
        Deque<Integer> increaseTemp = new ArrayDeque<>();
        for(int i =0 ; i<temperatures.length;i++){
            while (!increaseTemp.isEmpty() && temperatures[increaseTemp.peekLast()]<temperatures[i]){
                    int coldDay = increaseTemp.removeLast();
                    res[coldDay] = i-coldDay;
            }
            increaseTemp.addLast(i);
        }
        return res;
    }
}
