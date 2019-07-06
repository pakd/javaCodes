import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot single_instance = null;

    List<ParkingSpot> smallspotList = new ArrayList<>();
    List<ParkingSpot> mediumSpotList = new ArrayList<>();
    List<ParkingSpot> largeSpotList = new ArrayList<>();
    Map<String, ParkingSpot> parkedVehicle =  new HashMap<>();
    private ParkingLot() {
        int i=0;

        // small spots
        for(;i<10; i++) {
            ParkingSpot obj = new ParkingSpot(i, SpotSize.SMALL, false);
            smallspotList.add(obj);
        }

        // medium spots
        for(;i<20; i++) {
            ParkingSpot obj = new ParkingSpot(i, SpotSize.MEDIUM, false);
            mediumSpotList.add(obj);
        }

        // small spots
        for(;i<30; i++) {
            ParkingSpot obj = new ParkingSpot(i, SpotSize.LARGE, false);
            largeSpotList.add(obj);
        }
    }
    public static ParkingLot getInstance() {
        if(single_instance == null) {
            single_instance = new ParkingLot();
        }
        return single_instance;
    }

    public ParkingSpot removeVehicle(String plateNo) {
        for( String plate: ParkingLot.getInstance().parkedVehicle.keySet() ) {
            if(plate.equals(plateNo)) {
                ParkingSpot spot = ParkingLot.getInstance().parkedVehicle.get(plate);
                ParkingLot.getInstance().parkedVehicle.remove(plate);
                spot.setOccupied(false);
                return spot;
            }
        }
        return null;
    }
}
