package SPL_1;

import java.util.HashMap;

public class RandomNumberGenerator {

    static int size = 100;
    static int[] arrRand = new int[size];
    static int[] finalArr = new int[size];
    static int[] temp = new int[size];

    static int[] removeDuplicates(int[] temp, int n){

        HashMap<Integer, Boolean> mp = new HashMap<>();

        for (int i = 0; i < n; ++i){
            if (mp.get(temp[i]) == null)
                finalArr[i]=temp[i];

            mp.put(temp[i], true);
        }

        return finalArr;
    }
    public static int[] randomNumbers(int up){
        int seed = 16807;
        int mod = 2147483647;
        int mult = 123456789;

        int div = 39281473;
        //int up = 59;



        int x = ((seed*mult)) % mod;
        arrRand[0] = x/div;

        for(int i=0; i<size; i++){
            x = (x*seed) % mod;
            arrRand[i] = Math.abs(x/div);
            //arrRand[i] = (arrRand[i] - (arrRand[i]%6)) + 1;
        }
        int j = 0;

        for(int i=0; i<size; i++){

            if(arrRand[i] <= up){
                temp[j] = (arrRand[i] - (arrRand[i]%6)) + 1;
                j++;
            }
        }

        j = 0;

        removeDuplicates(temp, size);

        for(int i=0; i<size; i++){

            if(finalArr[i] != 0){
                finalArr[j] = finalArr[i];
                j++;
            }
        }

//        for(int i=0; i<size; i++){
//            //System.out.print(Math.abs(finalArr[i]));
//
//            System.out.print((finalArr[i]));
//
//            System.out.println(" ");
//
//        }
        return finalArr;
    }
}


