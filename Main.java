import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Inizializziamo un array di interi
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double vStrategia1=0, vStrategia2=0, vAtteso=5.5, vDiControllo=0;
        Random random=new Random();
        int a=10000000;
        for(int i=0; i<a; i++){
            List<Integer> list = Arrays.asList(array);

            // Mescoliamo l'array
            Collections.shuffle(list);
    
            // Convertiamo di nuovo la lista in un array
            list.toArray(array);
            int nPrimoPacchetto=random.nextInt(10);
            boolean b=true;
            int nSecondoPaccheto=0;
            vDiControllo+=array[nPrimoPacchetto];
            while (b) {
                nSecondoPaccheto=random.nextInt(10);
                if (nSecondoPaccheto!=nPrimoPacchetto) {
                    b=false;
                }
            }
            if(array[nSecondoPaccheto]>5){
                vStrategia1+=array[nPrimoPacchetto];
                int nTerzoPacchetto=random.nextInt(10);
                while ((nPrimoPacchetto!=nTerzoPacchetto)&&(nSecondoPaccheto!=nTerzoPacchetto)) {
                    nTerzoPacchetto=random.nextInt(10);
                }
                vStrategia2+=array[nTerzoPacchetto];
            }else{
                vStrategia2+=array[nPrimoPacchetto];
                int nTerzoPacchetto=random.nextInt(10);
                while ((nPrimoPacchetto!=nTerzoPacchetto)&&(nSecondoPaccheto!=nTerzoPacchetto)) {
                    nTerzoPacchetto=random.nextInt(10);
                }
                vStrategia1+=array[nTerzoPacchetto];
                
            }
            
       

        

    }
    vDiControllo=vDiControllo/a;
    vStrategia1=vStrategia1/a;
    vStrategia2=vStrategia2/a;
    System.err.println(vStrategia1+","+vStrategia2+","+vAtteso+";"+vDiControllo);
    }
}
