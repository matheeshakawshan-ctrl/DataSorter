package datasorter.sorting;

public class QuickSort {
    private int steps;

    public int[] sort(int[] arr) {
        steps = 0;
        if (arr == null) return new int[0];
        int[] result = arr.clone();
        quickSort(result, 0, result.length - 1);
        return result;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            steps++; // count the recursive partition step
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps++; // count comparisons / operations inside partition
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    public int getSteps() {
        return steps;
    }
}

