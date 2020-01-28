package GroupWorkTrain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StationTest {


    @Test
    public void readStationsJSONDataCreatesList(){
        Station s = new Station();

        assertNotNull(s.readStationJSONdata());
    }

    @Test
    public void convertHKIreturnsHelsinkiAsema(){
        Station s = new Station();
        List<Station> stations = s.readStationJSONdata();
        assertEquals("Helsinki asema", s.convertShortNameToLongName(stations, "HKI"));


    }
    @Test
    public void convertRaumareturnsRMA(){
        Station s = new Station();
        List<Station> stations = s.readStationJSONdata();
        assertEquals("RMA", s.convertLongNametoShortName(stations, "Rauma"));


    }
    @Test
    public void convertHelsinkiReturnsHKI(){
        Station s = new Station();
        List<Station> stations = s.readStationJSONdata();
        assertEquals("HKI", s.convertLongNametoShortName(stations, "Helsinki"));


    }
    @Test

    public void checkpassangerTrafficReturnsPassangerTrafficYesIfPassangerTrafficOnStation(){
        Station s = new Station();
        List<Station> stations = s.readStationJSONdata();
        assertEquals("Passenger traffic: Yes", s.checkPassangerTraffic(stations, "Helsinki"));
    }
    @Test
    public void searchStationsReturnsAllStationsInSameCity() {
        Station s = new Station();
        List<Station> stations = s.readStationJSONdata();
        List<String> cityStations = s.searchStations("Tampere", stations);
        assertEquals("Tampere asema:TPE", cityStations.get(0));
    }
    @Test
    public void listOnlyPassangerStaionsReturnsListWithOnlyStaionsWithPassangerTraffic() {
        Station s = new Station();
        List<Station> stations = s.readStationJSONdata();
        List<Station> passengerStations = s.listOnlyPassengerStations(stations);
        assertTrue(passengerStations.get(0).isPassengerTraffic());

    }

}