package interview;

/**
 * Created by stipturn on 4/20/17.
 */
public class Coinchange {


    public static void main(String[] args ) {

       // 1,2,3 10
        int count =0;
        for (int i = 0 ;i < 9; i++ )
            for (int j = 0; j < 9; j++)
                for (int k = 0; k < 9;k++)
                {
                    if(i!=j && i!=k && k!=j)
                    if(i+j+k == 10)
                        count ++;
                }

                System.out.println(count);
        System.out.println(numberOfSolutions(5,new int[] {1,2,3}));

    }



    public static int numberOfSolutions(int total, int coins[]){
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }
}
