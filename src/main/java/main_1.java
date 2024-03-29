//public class main {
//
//    public static int Sum(int N) {
//        int res = 0; // 0(1)
//        for (int i = 1; i <= N; i++) {
//            res += i;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Sum(10));
//    }
//}


//////// фибоначи
import java.util.Date;

public class main_1 {

    public static long F1(int N){
        if(N <= 2)
            return 1;
        return F1(N-1) + F1(N-2);
    }

    public static long F2(int N){
        if(N <= 2)
            return 1;

        long[] F = new long[N + 1];
        F[1] = 1;
        F[2] = 1;

        for(int i=3; i<=N; i++){
            F[i] = F[i-1] + F[i-2];
        }

        return F[N];
    }

    public static void test(){
        for(int N = 10; N <= 50; N++){
            Date start = new Date();
            F1(N);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            F2(N);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("N = %d, time1 = %d, time2 = %d%n", N, time1, time2);
        }
    }
    public static int Cubs(int K, int N){
        return Cubs(K, N, 1);
    }
    private static int Cubs(int K, int N, int H) {
        if(H == K + 1){
            return 1;
        }
        int res = 0;
        for(int g = 1; g <= N; g++){
            res += Cubs(K, N, H + 1);
        }
        return res;
    }
    public static void Simple(int N){
        for(int num = 2; num <= N; num++) {
            boolean simple = true;
            for (int p = 2; p * p <= num; p++){
                if(num % p == 0){
                    simple = false;
                    break;
                }
            }
            if(simple) {
                System.out.printf("%d ", num);
            }
        }
    }
    public static int Sum(int N){ // O(Sum(N)) = O(1) + O(N) + O(1) = O(N + 2) = O(N)
        int res = 0; // O(1)
        for(int i = 1; i <= N; i++){ // O(N)
            res += i; // O(1)
        }
        return res; // O(1)
    }

    public static void main(String[] args) {
        //System.out.println(Sum(3));
        //Simple(100);
        //System.out.println(Cubs(4, 6));

        //System.out.println(F2(50));

        test();
    }
}