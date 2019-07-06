public abstract class Vehicle {
    private String registrationPlateNo;
    private VehicleSize vehicleSize;

    Vehicle(String registrationPlateNo, VehicleSize vehicleSize) {
        this.registrationPlateNo = registrationPlateNo;
        this.vehicleSize = vehicleSize;
    }

    String getRegistrationPlateNo() {
        return registrationPlateNo;
    }

    VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public abstract ParkingSpot parkVehicle(Vehicle vehicle);

}
