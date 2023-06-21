import java.util.Date;
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

/////////// далее нужно разобраться


//public class piram_sort {
//    final static int[] buf = new int[100000];
//    static public void ShakeSort(int[] Array){ // O(N^2)
//        for(int i = 0; i < Array.length/2; i++){
//            for(int j = i; j < Array.length - i - 1; j++){
//                if(Array[j] > Array[j+1]){
//                    int temp = Array[j];
//                    Array[j] = Array[j+1];
//                    Array[j+1] = temp;
//                }
//            }
//            for(int j = Array.length - i - 1; j > i; j--){
//                if(Array[j - 1] > Array[j]){
//                    int temp = Array[j - 1];
//                    Array[j - 1] = Array[j];
//                    Array[j] = temp;
//                }
//            }
//        }
//    }

//    static public void MergeSort(int[] Array) {
//        MergeSort(Array, 0, Array.length - 1);
//    }
//    static private void MergeSort(int[] Array, int left, int right) {
//        if(left == right){
//            return;
//        }
//        int mid = (left + right) / 2;
//        MergeSort(Array, left, mid);
//        MergeSort(Array, mid+1, right);
//
//        //РЎР»РёСЏРЅРёРµ
//        int i = left, j = mid + 1, k = left;
//        while(i <= mid && j <= right){
//            if(Array[i] < Array[j]){
//                buf[k] = Array[i];
//                i++;
//            }else{
//                buf[k] = Array[j];
//                j++;
//            }
//            k++;
//        }
//
//        while(i <= mid){
//            buf[k++] = Array[i++];
//        }
//
//        while(j <= right){
//            buf[k++] = Array[j++];
//        }
//
//        for(int q = left; q<=right; q++)
//            Array[q] = buf[q];
//    }
//
//    public static Integer BinarySearch(int[] Array, int value){
//        int left = 0, right = Array.length - 1;
//        while(right - left > 1){ // abs(right-left) > eps (1e-9)
//            int mid = (left + right) / 2;
//            if(Array[mid] > value){
//                right = mid;
//            }else{
//                left = mid;
//            }
//        }
//        if(Array[left] == value)
//            return left;
//        if(Array[right] == value)
//            return right;
//        return null;
//    }
//    public static void main(String[] args) {
//        int N = 100000;
//        int[] Array1 = new int[N];
//        //int[] Array2 = new int[N];
//        for(int i=0; i<N; i++){
//            Array1[i] = (int)(Math.random() * 1000);
//            //Array2[i] = Array1[i];
//        }
//
//        //Date start = new Date();
//        //ShakeSort(Array1);
//        //Date end = new Date();
//        //long time1 = end.getTime() - start.getTime();
//
//        //start = new Date();
//        MergeSort(Array1);
//        //end = new Date();
//        //long time2 = end.getTime() - start.getTime();
//
//        //System.out.printf("time1 = %d, time2 = %d%n", time1, time2);
//
//        System.out.println(BinarySearch(Array1, 555));
//
//    }
//}
////time1 = 11265, time2 = 24
////time1 = 11130, time2 = 0
////time1 = 0, time2 = 23