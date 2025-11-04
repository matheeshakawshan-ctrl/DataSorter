package datasorter.sorting;

public class BubbleSort {
    private int steps;

    public int[] sort(int[] arr) {
        steps = 0;
        if (arr == null) return new int[0];
        int[] result = arr.clone();
        int n = result.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    public int getSteps() {
        return steps;
    }
}