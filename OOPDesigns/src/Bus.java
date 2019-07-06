public class Bus extends Vehicle {
    Bus(String registrationPlateNo) {
        super(registrationPlateNo, VehicleSize.CAR);
    }
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : ParkingLot.getInstance().largeSpotList) {
            if(spot.isOccupied() == false) {
                spot.setOccupied(true);
                ParkingLot.getInstance().parkedVehicle.put(vehicle.getRegistrationPlateNo(), spot);
                return spot;
            }
        }
        return null;
    }

}
