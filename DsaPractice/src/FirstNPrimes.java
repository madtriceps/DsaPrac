package DsaPrac.DsaPractice.src;
/*
two inputs 'N' and 'M' are given.
You have to use first 'N' prime nos to make a given number (sum).
you have to minimize the number of prime nos used
eg: N = 3 , M = 10
 so we can use first 3 prime nos => {2,3,5}
 we can have guess like => {2,2,2,2,2} but it uses 5 numbers in total.
 whereas if we use => {5+5}, it only uses 2 coins so thast the answer as it uses minimum no. of prime nos avaible

 This is the same question as "Minimum coins problem"
 */
public class FirstNPrimes {
    static int[][] tab;


    static int[] mPrimesGenerator(int M){
        if(M==1){
            return new int[]{2};
        }
        if(M==2){
            return new int[]{3};
        }

        int[] nn = new int[M];
        nn[0]=2;
        nn[1]=3;

        int counter =2;
        int i=4;

        while(counter!=M){
            if(isPrime(i)){
                nn[counter++]=i;
            }
            i +=1;
        }
        return nn;
    }

    static boolean isPrime(int M){
        int i=2;
        while(i<=M-1){
            if(M%i == 0){
                return false;
            }
            i++;
        }
        return true;
    }

    //  N--> Number of primes
//  M--> target sum
    static int minNumbersNeeded(int N, int M){
        int[] primes = mPrimesGenerator(N);

        tab = new int[N+1][M+1];

        // Initialize the table
        for (int j = 0; j <= M; j++) {
            tab[0][j] = Integer.MAX_VALUE - 1; // Impossible to make positive sum with 0 coins
        }
        tab[0][0] = 0; // 0 coins are needed to make the sum of 0

        for (int i = 1; i <= N; i++) {
            tab[i][0] = 0; // 0 coins are needed to make the sum of 0
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (primes[i - 1] <= j) {
                    tab[i][j] = Math.min(tab[i][j - primes[i - 1]] + 1, tab[i - 1][j]);
                } else {
                    tab[i][j] = tab[i - 1][j];
                }
            }
        }
        return tab[N][M];
    }

    public static void main(String[] args) {
        System.out.println(minNumbersNeeded(3,11));
    }
}
