package SPL_1;

public class RandomNumberGenerator {
    public static int[] randomNumbers(int size, int up){
        int seed = 16807;
        int mod = 2147483647;
        int mult = 123456789;
        //int size = 100;
        int div = 39281473;
        //int up = 60;

        int[] arrRand = new int[size];
        int[] finalArr = new int[size];

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
                finalArr[j] = (arrRand[i] - (arrRand[i]%6)) + 1;
                j++;
            }
        }

        j = 0;
        int[] temp = new int[size];
        for(int i=0; i<size-1; i++){
            if (finalArr[i] != finalArr[i+1]){
                temp[j++] = finalArr[i];
            }
        }
        temp[j++] = finalArr[size-1];
        // Changing original array
        for(int i=0; i<j; i++){
            finalArr[i] = temp[i];
        }

//        for(int i=0; i<size; i++){
//            System.out.print(Math.abs(finalArr[i]));
//            System.out.println(" ");
//
//        }
        return finalArr;
    }
}
