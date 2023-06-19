public class piram_sort {
    public static void sort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            heapify(array, heapSize, largest);
        }
    }
    public static void main(String[] args) {
        int N = 13;
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = (int) (Math.random() * 100);
        }
        for(int a: Array)
            System.out.printf("%d ", a);
        System.out.println();

        sort(Array);

        for(int a: Array)
            System.out.printf("%d ", a);
        System.out.println();
    }
}
