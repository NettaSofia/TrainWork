package GroupWorkTrain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.net.URI;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Train {
    public static void main(String[] args) {
        lueJunanJSONData();
    }


    private static void lueJunanJSONData() {
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        try {
            URL url = new URL(URI.create(String.format("%s/live-trains/station/HKI/LH", baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            List<Juna> junat = mapper.readValue(url, tarkempiListanTyyppi);  // pelkkä List.class ei riitä tyypiksi
            System.out.println(junat.get(0).getTrainNumber());
            // Seuraavaa varten on toteutettava GroupWorkTrain.TimeTableRow luokka:
            System.out.println(junat.get(0).getTimeTableRows().get(0).getScheduledTime());
            System.out.println("\n\n");
            System.out.println(junat.get(0));

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public List<Juna> lueJunanJSONDataListaan(String asema) {
        String baseurl = "https://rata.digitraffic.fi/api/v1";
        String urlLoppu ="%s/live-trains/station/" +asema +"/";
        try {
            URL url = new URL(URI.create(String.format(urlLoppu, baseurl)).toASCIIString());
            ObjectMapper mapper = new ObjectMapper();
            CollectionType tarkempiListanTyyppi = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Juna.class);
            System.out.println(tarkempiListanTyyppi);
            List<Juna> junat = mapper.readValue(url, tarkempiListanTyyppi);  // pelkkä List.class ei riitä tyypiksi
            return junat;



        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    public String makeTrainsReadable(Juna j, String destination) {
        StationList sl = new StationList();
        int indeksi = 0;
        String destinationAndTime = null;
        while(indeksi<j.getTimeTableRows().size()){
                 if (j.getTimeTableRows().get(indeksi).getStationShortCode().equals(destination)){
                     destinationAndTime = j.getTimeTableRows().get(indeksi).getStationShortCode() +", " +j.getTimeTableRows().get(indeksi).getScheduledTime();
                 }

            }return j.getTimeTableRows().get(0).getStationShortCode() +j.getTimeTableRows().get(0).getScheduledTime() +destinationAndTime +j.getTimeTableRows().get(j.getTimeTableRows().size()).getStationShortCode() +j.getTimeTableRows().get(j.getTimeTableRows().size()).getScheduledTime();
        }

    public static String makeTrainsReadable(Juna j) {
        StationList sl = new StationList();
        String[] split1 = j.getTimeTableRows().get(0).getScheduledTime().split("T");
        String departureTime =  split1[1].substring(0,7);
        String[] split2 = j.getTimeTableRows().get(j.getTimeTableRows().size()-1).getScheduledTime().split("T");
        String arrivalTime = split2[1].substring(0,7);
        return sl.convertShortNameToLongName(j.getTimeTableRows().get(0).getStationShortCode()) +" lähtöaika:" +departureTime +" " +sl.convertShortNameToLongName(j.getTimeTableRows().get(j.getTimeTableRows().size()-1).getStationShortCode()) +" saapuminen:" +arrivalTime;
    }


    public List<Juna> listTrainsGoingToStation(String station, List<Juna> list) {
        List<Juna> listOfTrainsGoingToStation = new ArrayList<>();
        for(Juna j : list) {
            int indeksi = 0;
            while(indeksi<j.getTimeTableRows().size()){
                if(j.getTimeTableRows().get(indeksi).getStationShortCode().equals(station)){
                    listOfTrainsGoingToStation.add(j);
                } indeksi++;
            }
        }
        return listOfTrainsGoingToStation;
    }
}


class Juna {
    boolean cancelled;
    String commuterLineID;
    //LocalDate departureDate;  // Jackson ei oikein pidä Java 8 päivistä oletuksena
    Date departureDate;
    String operatorShortCode;
    int operatorUICCode;
    boolean runningCurrently;
    List<TimeTableRow> timeTableRows;
    Date timetableAcceptanceDate;
    String timetableType;
    String trainCategory;
    int trainNumber;
    String trainType;
    long version;

    @Override
    public String toString() {
        return timeTableRows.toString()+"\n";
    }
    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getCommuterLineID() {
        return commuterLineID;
    }

    public void setCommuterLineID(String commuterLineID) {
        this.commuterLineID = commuterLineID;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getOperatorShortCode() {
        return operatorShortCode;
    }

    public void setOperatorShortCode(String operatorShortCode) {
        this.operatorShortCode = operatorShortCode;
    }

    public int getOperatorUICCode() {
        return operatorUICCode;
    }

    public void setOperatorUICCode(int operatorUICCode) {
        this.operatorUICCode = operatorUICCode;
    }

    public boolean isRunningCurrently() {
        return runningCurrently;
    }

    public void setRunningCurrently(boolean runningCurrently) {
        this.runningCurrently = runningCurrently;
    }

    public List<TimeTableRow> getTimeTableRows() {
        return timeTableRows;
    }

    public void setTimeTableRows(List<TimeTableRow> timeTableRows) {
        this.timeTableRows = timeTableRows;
    }

    public Date getTimetableAcceptanceDate() {
        return timetableAcceptanceDate;
    }

    public void setTimetableAcceptanceDate(Date timetableAcceptanceDate) {
        this.timetableAcceptanceDate = timetableAcceptanceDate;
    }

    public String getTimetableType() {
        return timetableType;
    }

    public void setTimetableType(String timetableType) {
        this.timetableType = timetableType;
    }

    public String getTrainCategory() {
        return trainCategory;
    }

    public void setTrainCategory(String trainCategory) {
        this.trainCategory = trainCategory;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class TimeTableRow {
   boolean trainStopping;
   String stationShortCode;
   int stationUICCode;
   String countryCode;
   String type;
   String commercialTrack;
   boolean cancelled;
   String scheduledTime;

    public boolean isTrainStopping() {
        return trainStopping;
    }

    public void setTrainStopping(boolean trainStopping) {
        this.trainStopping = trainStopping;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommercialTrack() {
        return commercialTrack;
    }

    public void setCommercialTrack(String commercialTrack) {
        this.commercialTrack = commercialTrack;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public String toString() {
        return stationShortCode + scheduledTime;
    }
}
