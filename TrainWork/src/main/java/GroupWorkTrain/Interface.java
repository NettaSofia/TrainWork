package GroupWorkTrain;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static GroupWorkTrain.Train.listaJunastaJotkaMenevatAsemastaAAsemaanB;
import static GroupWorkTrain.Train.printTrainTimesAtStationAandB;

public class Interface {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        StationList l= new StationList();
        stationSearch(scanner, l);

    }

    private static void stationSearch(Scanner scanner, StationList l) {
        System.out.print("Syötä lähtöasema: ");
        String lahtoasema = scanner.nextLine();
        l.isStation(lahtoasema);
        System.out.print("Syötä päätepysäkki: ");
        String paatepysakki = scanner.nextLine();
        l.isStation(paatepysakki);
        List<Juna> list = new ArrayList<>();
        list = listaJunastaJotkaMenevatAsemastaAAsemaanB(lahtoasema, paatepysakki);
        if(list ==null){
            System.out.println("Hakemiesi asemien väliltä ei löydy yhteyksiä.");
            Interface.run();
            return;
        }
        try {
            System.out.println("Hakemallesi välille löytyi seuraavia lähtöjä: ");
            for (Juna j : list) {
                System.out.println(printTrainTimesAtStationAandB(j, lahtoasema, paatepysakki));

            }
            System.exit(0);
        }catch (NullPointerException e){
            System.out.println();
        }
    }
}



