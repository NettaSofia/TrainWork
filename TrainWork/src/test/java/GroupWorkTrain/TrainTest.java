package GroupWorkTrain;

import org.junit.Test;

import java.util.List;

import static GroupWorkTrain.Train.*;
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

  //  @Test
    //public void testMethodListTrainsGoingFRomStationAtoStationB(){
      //  List<Juna> lista= listaJunastaJotkaMenevatAsemastaAAsemaanB("Vaasa","Tampere");
        //for(Juna j :lista) {
          //  System.out.println(printTrainTimesAtStationAandB(j, "Vaasa", "Tampere"));
       // }
       //assertNotNull(lista);
    //}

    @Test
    public void testMethod2ListTrainsGoingFRomStationAtoStationB(){
        List<Juna> lista= toinenListaJunastaJotkaMenevatAsemastaAAsemaanB("Vaasa", "Tampere");
        for(Juna j :lista) {
            System.out.println(printTrainTimesAtStationAandB(j, "Vaasa", "Tampere"));
        }
        assertNotNull(lista);
    }
    @Test
    public void testaaKahdellavaihdolla(){
        listaJunastaPaikastaApaikkaanByhdellaVaihdolla("Kemijärvi","Imatra");
        assertNotNull(listaJunastaJotkaMenevatAsemastaAAsemaanB("Kemijärvi","Imatra"));
    }






}