package GroupWorkTrain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Station {
    private boolean passengerTraffic;
    private String countryCode;
    private String stationName;
    private String stationShortCode;
    private int stationUICCode;
    private double latitude;
    private double longitude;
    private String type;

    public static void main(String[] args) {

        List<Station> trainstations = readStationJSONdata();
        for (Station s : trainstations) {
            System.out.println(s);
        }

    }

    public Station() {
    }

    public static List<Station> readStationJSONdata() {
        String baseurl = "https://rata.digitraffic.fi/api/v1";

        try {
            URL url = new URL(URI.create(String.format("%s/metadata/stations", baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Station.class);
            List<Station> stations = mapper.readValue(url, tarkempiListanTyyppi);


            return stations;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;


    }

    public boolean isPassengerTraffic() {
        return passengerTraffic;
    }

    public void setPassengerTraffic(boolean passengerTraffic) {
        this.passengerTraffic = passengerTraffic;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationShortCode() {
        return stationShortCode;
    }

    public void setStationShortCode(String stationShortCode) {
        this.stationShortCode = stationShortCode;
    }

    public int getStationUICCode() {
        return stationUICCode;
    }

    public void setStationUICCode(int stationUICCode) {
        this.stationUICCode = stationUICCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return stationName +", " +stationShortCode +", " +passengerTafficYesOrNo() +", " +countryCode;
    }

    public String convertShortNameToLongName(List<Station> list, String shortName) {
        String longName = null;
        for (Station s : list) {
            if (s.getStationShortCode().equals(shortName)) {
                longName = s.getStationName();
            }
        }
        return longName;
    }

    public String convertLongNametoShortName(List<Station> list, String longName) {
        String shortName = null;
        String kaupunkiJaAsema = (longName +" asema");
        for (Station s : list) {
            if ((s.getStationName().equals(longName)|| s.getStationName().equals(kaupunkiJaAsema))) {
                shortName = s.getStationShortCode();
               }
        }
        return shortName;
    }

    public String checkPassangerTraffic(List<Station> list, String station) {
        String shortName = convertLongNametoShortName(list, station);
        for(Station s : list){
            if(s.getStationShortCode().equals(shortName)){
                if(s.isPassengerTraffic()){
                    return "Passenger traffic: Yes";
                }
            }
        }return "Passenger traffic: No";

    }
    public String passengerTafficYesOrNo(){
        if(isPassengerTraffic()){
            return "Passenger traffic: Yes";
        }
        return "Passenger traffic: No";
    }

    public List<String> searchStations(String city, List<Station> list) {
        List<String> stationsInCity = new ArrayList<>();
        for(Station s : list){
            if(s.getStationName().contains(city)){
                String stationNameAndShort = s.getStationName() +":" +s.getStationShortCode();
                stationsInCity.add(stationNameAndShort);
            }
        }
        return stationsInCity;
    }

    public static List<Station> listOnlyPassengerStations(List<Station> list) {
        List<Station> passengerStations = new ArrayList<>();
        for (Station s : list) {
            if(s.isPassengerTraffic()){
                passengerStations.add(s);
            }
        }
        return passengerStations;
    }
}