package Game.Floors;

public class Floors {
    private int currentFloor;

    public Floors() {
        this.currentFloor = 1;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void buildFloor() {
        currentFloor++;

        if (currentFloor % 10 == 0) {
            // boss floor
        } else if (currentFloor % 5 == 0) {
            // medium enemy floor
        } else {
            // small enemy floor
        }
    }
}