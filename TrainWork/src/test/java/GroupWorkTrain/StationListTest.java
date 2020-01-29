package GroupWorkTrain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StationListTest {
    @Test
    public void StationListIsNotEmptyWhenCreated(){
        StationList list = new StationList();
        assertNotNull(list.getList());
    }
    @Test
    public void convertHelsinkiReturnsHKI() {
        StationList l = new StationList();
        assertEquals("HKI", l.convertLongNametoShortName("Helsinki"));
    }
    @Test
    public void searchStationsReturnsAllStationsInSameCity() {
        StationList l = new StationList();
        List<String> cityStations = l.searchStations("Tampere");
        assertEquals("Tampere asema:TPE", cityStations.get(0));
    }
    @Test
    public void convertHKIreturnsHelsinkiAsema() {
        StationList l = new StationList();
        assertEquals("Helsinki asema", l.convertShortNameToLongName("HKI"));
    }
  //  @Test
   // public void isStationTunnistaaEttaHelsinkiOnAsema(){
     //   StationList l = new StationList();
       // assertTrue(l.isStation("Helsinki"));
 //   }
   // @Test
    //public void SoderkullaEiOleAsema(){
      //  StationList l = new StationList();
        //assertTrue(l.isStation("Söderkulla"));
 //   }

}