class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int g: gas){
            totalGas +=g;
        }
        for(int c:cost){
            totalCost+=c;
        }
        if(totalCost>totalGas){
            return -1;
        }
        
        int netGas = 0;
        int start = 0;
        for(int i =0; i<gas.length; i++){
            if(netGas+gas[i]-cost[i]<0){
                netGas = 0;
                start = i+1;
            } else {
                netGas = netGas+gas[i]-cost[i];
            }
        }
        return start;
        
    }
}