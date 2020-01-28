package GroupWorkTrain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrainTest {
    @Test
    public void lueJunanJSONDataListaanPalauttaaListan(){
        Train t = new Train();
        List<Juna> lista = t.lueJunanJSONDataListaan("HKI");
        System.out.println(lista);
        assertNotNull(lista);
    }



}