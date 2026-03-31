class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> cars = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(int i =0; i<position.length; i++){
            cars.add(new int[]{position[i], speed[i]});
        }
        int fleet = 0;
        double currToptime = 0;

        while(!cars.isEmpty()){
            int[] topCar = cars.poll();
            double time = (double)(target-topCar[0])/topCar[1];
            if (time>currToptime){
                fleet++;
                currToptime = time;
            } 
        }
        return fleet;
    }
}
