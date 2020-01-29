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
        System.out.print("Syötä lähtöasema: ");
        String lahtoasema = scanner.nextLine();
        System.out.print("Syötä päätepysäkki: ");
        String paatepysakki = scanner.nextLine();

        List<Juna> list = new ArrayList<>();
        try {
            list = listaJunastaJotkaMenevatAsemastaAAsemaanB(lahtoasema, paatepysakki);
        }
        catch (NullPointerException e) {
            System.out.println("Hakemiesi asemien väliltä ei löydy yhteyksiä.");
            Interface.run();
        }
        System.out.println("Hakemallesi välille löytyi seuraavia lähtöjä: ");
        for (Juna j : list) {
                System.out.println(printTrainTimesAtStationAandB(j, lahtoasema, paatepysakki));

            }

        }
    }



