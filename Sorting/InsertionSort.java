public class Insertion {
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];      // element to be placed
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;      // place key at correct position
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5, 6, 4, 3};
        Insertion sorter = new Insertion();
        sorter.insertionSort(arr);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
