package GroupWorkTrain;

import java.util.ArrayList;
import java.util.List;

import static GroupWorkTrain.Station.listOnlyPassengerStations;
import static GroupWorkTrain.Station.readStationJSONdata;

public class StationList extends ArrayList {
    private List<Station> list;
    private  List<Station> passengerStationList;

    public StationList(){
        this.list = readStationJSONdata();
        this.passengerStationList = listOnlyPassengerStations(readStationJSONdata());
    }

    public List<Station> getList() {
        return list;
    }

    public List<Station> getPassengerStationList() {
        return passengerStationList;
    }

    public String convertLongNametoShortName(String longName) {
        String shortName = null;
        String kaupunkiJaAsema = (longName + " asema");
        for (Station s : list) {
            if ((s.getStationName().equals(longName) || s.getStationName().equals(kaupunkiJaAsema))) {
                shortName = s.getStationShortCode();
            }
        }
        return shortName;
    }
    public boolean isStation(String longName) {
        String kaupunkiJaAsema = (longName + " asema");
        for (Station s : list) {
            if ((s.getStationName().toUpperCase().equals(longName.toUpperCase()) || s.getStationName().toUpperCase().equals(kaupunkiJaAsema.toUpperCase()))) {
                return true;
            }
        }
        System.out.println("Syöte ei ole asema");
        Interface.run();
        return false;
    }
    public List<String> searchStations(String city) {
        List<String> stationsInCity = new ArrayList<>();
        for(Station s : list){
            if(s.getStationName().contains(city)){
                String stationNameAndShort = s.getStationName() +":" +s.getStationShortCode();
                stationsInCity.add(stationNameAndShort);
            }
        }
        return stationsInCity;
    }

    public String convertShortNameToLongName(String shortName) {
        String longName = null;
        for (Station s : list) {
            if (s.getStationShortCode().equals(shortName)) {
                longName = s.getStationName();
            }
        }
        return longName;
    }
}
