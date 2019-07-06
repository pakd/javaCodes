import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isStop = false;


        while(!isStop) {
            System.out.println("Press 1 for park Vehicle");
            System.out.println("Press 2 for remove Vehicle");
            System.out.println("Press 3 for list of all vehicles currently parked");
            System.out.println("Press 4 for exit");

            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            //System.out.println(input);

            switch (input) {
                case 1:

                    System.out.println("Press Enter the registration plate no of vehicle");
                    in.nextLine();
                    String registrationPlateNo = in.nextLine();
                    // System.out.println(registrationPlateNo);

                    Car car = new Car(registrationPlateNo);

                    ParkingSpot spot = car.parkVehicle(car);

                    if(spot != null) {
                        System.out.println("Allocate slot no: " + spot.getSpotId());
                    } else {
                        System.out.println("No slots available");
                    }

                    break;

                case 2:

                    System.out.println("Press Enter the registration plate no of vehicle");
                    in.nextLine();
                    String registrationPlateNo2 = in.nextLine();
                    ParkingSpot spot2 = ParkingLot.getInstance().removeVehicle(registrationPlateNo2);
                    System.out.println("freed slot no: " + spot2.getSpotId());

                    break;
                case 3:
                    for(String plate : ParkingLot.getInstance().parkedVehicle.keySet()) {
                        System.out.println(plate + " : " + ParkingLot.getInstance().parkedVehicle.get(plate).getSpotId());
                    }
                    break;
                case 4:
                    isStop = true;
                    break;
                default:

            }


        }

    }
}
