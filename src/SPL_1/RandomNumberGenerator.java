package SPL_1;
import java.util.Random;

public class RandomNumberGenerator {
    public static int[] randomNumbers(int size){
        int mult = 16807;
        int mod = 2147483647;
        int seed = 123456789;
        int div = 19876549;
        //int size = 60;

        int[] arrRand = new int[size];

        int x = ((seed*mult)+1) % mod;
        arrRand[0] = x/div;

        for(int i=0; i<size; i++){
            x = ((x*mult)+1) % mod;
            arrRand[i] = Math.abs(x/div);
            arrRand[i] = (arrRand[i] - (arrRand[i]%6)) + 1;
        }

//        for(int i=0; i<size; i++){
//            System.out.print(Math.abs(arrRand[i]));
//            System.out.println(" ");
//
//        }
        return arrRand;
    }
}
