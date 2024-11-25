import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double vStrategia1 = 0, vStrategia2 = 0, vAtteso = 5.5, vDiControllo = 0;
        Random random = new Random();
        int a = 10000000;

        for (int i = 0; i < a; i++) {
            // Mescoliamo l'array
            List<Integer> list = Arrays.asList(array);
            Collections.shuffle(list);
            Integer[] shuffledArray = list.toArray(new Integer[0]);

            // Selezione del primo pacchetto
            int nPrimoPacchetto = random.nextInt(10);
            vDiControllo += shuffledArray[nPrimoPacchetto];

            // Selezione del secondo pacchetto (diverso dal primo)
            int nSecondoPacchetto;
            do {
                nSecondoPacchetto = random.nextInt(10);
            } while (nSecondoPacchetto == nPrimoPacchetto);

            // Strategia basata sul valore del secondo pacchetto
            if (shuffledArray[nSecondoPacchetto] > 5) {
                // Strategia 1: Mantieni il primo pacchetto
                vStrategia1 += shuffledArray[nPrimoPacchetto];

                // Strategia 2: Cambia con un terzo pacchetto
                int nTerzoPacchetto;
                do {
                    nTerzoPacchetto = random.nextInt(10);
                } while (nTerzoPacchetto == nPrimoPacchetto || nTerzoPacchetto == nSecondoPacchetto);
                vStrategia2 += shuffledArray[nTerzoPacchetto];
            } else {
                // Strategia 1: Cambia con un terzo pacchetto
                int nTerzoPacchetto;
                do {
                    nTerzoPacchetto = random.nextInt(10);
                } while (nTerzoPacchetto == nPrimoPacchetto || nTerzoPacchetto == nSecondoPacchetto);
                vStrategia1 += shuffledArray[nTerzoPacchetto];

                // Strategia 2: Mantieni il primo pacchetto
                vStrategia2 += shuffledArray[nPrimoPacchetto];
            }
        }

        // Calcolo delle medie
        vDiControllo /= a;
        vStrategia1 /= a;
        vStrategia2 /= a;

        // Stampa dei risultati
        System.err.println("Strategia 1: " + vStrategia1);
        System.err.println("Strategia 2: " + vStrategia2);
        System.err.println("Valore atteso: " + vAtteso);
        System.err.println("Controllo: " + vDiControllo);
    }
}

