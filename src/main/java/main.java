public class main {

    public static int Sum(int N) {
        int res = 0; // 0(1)
        for (int i = 1; i <= N; i++) {
            res += i;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Sum(10));
    }
}

