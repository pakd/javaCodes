public class ParkingSpot {

    private int spotId;
    private SpotSize spotSize;
    private boolean occupied;

    ParkingSpot(int spotId, SpotSize spotSize, boolean occupied) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.occupied = occupied;
    }

    int getSpotId() {
        return spotId;
    }

    SpotSize getSpotSize() {
        return spotSize;
    }

    boolean isOccupied() {
        return occupied;
    }

    void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
