public class Day06 {


    public int calculateBoatDistance(int time, int holdTime) {

        int travelTime = time - holdTime;

        return holdTime * travelTime;
    }
}
