package GroupWorkTrain;

import org.junit.Test;

import java.util.List;

import static GroupWorkTrain.Train.makeTrainsReadable;
import static GroupWorkTrain.Train.printTrainTimesAtStationAandB;
import static org.junit.Assert.*;

public class TrainTest {
    @Test
    public void lueJunanJSONDataListaanPalauttaaListan(){
        Train t = new Train();
        List<Juna> lista = t.lueJunanJSONDataListaan("HKI");
        System.out.println(lista);
        assertNotNull(lista);
    }
    @Test
    public void searchTrainThatGoToStationReturnsListOfTrainsGoingToTheStation() {
        Train t = new Train();
        List<Juna> lista = t.lueJunanJSONDataListaan("TPE");
        List<Juna> goingToStation = t.listTrainsGoingToStation("PSL", lista);
        for (Juna j : goingToStation) {
            System.out.println(makeTrainsReadable(j));
        }
        assertNotNull(goingToStation);
    }

    @Test
    public void testMethodListTrainsGoingFRomStationAtoStationB(){
        Train t = new Train();
       List<Juna> lista= t.listaJunastaJotkaMenevatAsemastaAAsemaanB("Vaasa","Tampere");
        for(Juna j :lista) {
            System.out.println(printTrainTimesAtStationAandB(j, "Vaasa", "Tampere"));
        }
       assertNotNull(lista);
    }






}