package Templates;

public class Sort {


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 3, 5, 9, 10, 7, 200, 12};
        arr = insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] insertionSort(int[] arr) {
        int n = arr.length;

        // loop through the array
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i -1;
            
            //compare the current element(key) to the previous element (arr[j])
            //if it's greater, then shift arr[j] up the array by one
            //then compare the element before j with key. 
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            //finally shift key in front of everything that's larger than it. 
            arr[j + 1] = key; 
        }
        return arr;
    }

}