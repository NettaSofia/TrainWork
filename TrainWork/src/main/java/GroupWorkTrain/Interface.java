package GroupWorkTrain;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

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
        System.out.println("Hakemallesi välille löytyi seuraavia lähtöjä: ");
        listaJunastaJotkaMenevatAsemastaAAsemaanB(lahtoasema, paatepysakki);
        for (Juna j : listaJunastaJotkaMenevatAsemastaAAsemaanB(lahtoasema, paatepysakki)) {
            System.out.println(printTrainTimesAtStationAandB(j, lahtoasema, paatepysakki));
        }
    }
}

