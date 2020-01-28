package GroupWorkTrain;

import java.util.Scanner;

import static GroupWorkTrain.Train.listaJunastaJotkaMenevatAsemastaAAsemaanB;
import static GroupWorkTrain.Train.printTrainTimesAtStationAandB;

public class Interface {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Syötä lähtöasema: ");
        String lahtoasema = scanner.nextLine();
        System.out.println("Syötä päätepysäkki: ");
        String paatepysakki = scanner.nextLine();
        listaJunastaJotkaMenevatAsemastaAAsemaanB(lahtoasema, paatepysakki);
        for (Juna j : listaJunastaJotkaMenevatAsemastaAAsemaanB(lahtoasema, paatepysakki)) {
            System.out.println(printTrainTimesAtStationAandB(j, lahtoasema, paatepysakki));

        }

    }
}
