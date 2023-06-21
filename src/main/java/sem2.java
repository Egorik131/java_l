// Шейкерная сортирвка

public class sem2 {
    static public void SnakeSort(int[] Array) { // O(N^2)
        for (int i = 0; i < Array.length / 2; i++) {
            for (int j = i; j < Array.length - i - 1; j++) {
                if (Array[j] > Array[j + 1]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
            for (int j = Array.length - i - 1; j > i; j--) {
                if (Array[j - 1] > Array[j]) {
                    int temp = Array[j - 1];
                    Array[j - 1] = Array[j];
                    Array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = (int) (Math.random() * 100);
        }
        for(int a: Array)
            System.out.printf("%d ", a);
        System.out.println();

        SnakeSort(Array);

        for(int a: Array)
            System.out.printf("%d ", a);
        System.out.println();
    }
}


// Сортировка слиянием (Merge Sort) O(N log(N)