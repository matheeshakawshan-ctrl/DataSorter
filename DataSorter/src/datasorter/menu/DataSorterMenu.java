package datasorter.menu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import datasorter.sorting.BubbleSort;
import datasorter.sorting.MergeSort;
import datasorter.sorting.QuickSort;

public class DataSorterMenu {
    private int[] data;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    enterNumbers();
                    break;
                case 2:
                    generateRandomNumbers();
                    break;
                case 3:
                    performBubbleSort();
                    break;
                case 4:
                    performMergeSort();
                    break;
                case 5:
                    performQuickSort();
                    break;
                case 6:
                    compareAll();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
        sc.close();
    }

    private void enterNumbers() {
        System.out.print("Enter numbers separated by spaces: ");
        String[] parts = sc.nextLine().split(" ");
        data = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                data[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, defaulting to 0.");
                data[i] = 0;
            }
        }
        System.out.println("Numbers added successfully!");
    }

    private void generateRandomNumbers() {
        System.out.print("Enter number of random elements: ");
        int n = sc.nextInt();
        data = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) data[i] = rand.nextInt(100);
        System.out.println("Random numbers generated: " + Arrays.toString(data));
    }

    private void performBubbleSort() {
        if (checkData()) return;
        BubbleSort bs = new BubbleSort();
        int[] copy = data.clone();
        long start = System.nanoTime();
        bs.sort(copy);
        long end = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(copy));
        System.out.println("Steps: " + bs.getSteps());
        System.out.println("Time (ns): " + (end - start));
    }

    private void performMergeSort() {
        if (checkData()) return;
        MergeSort ms = new MergeSort();
        int[] copy = data.clone();
        long start = System.nanoTime();
        ms.sort(copy);
        long end = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(copy));
        System.out.println("Steps: " + ms.getSteps());
        System.out.println("Time (ns): " + (end - start));
    }

    private void performQuickSort() {
        if (checkData()) return;
        QuickSort qs = new QuickSort();
        int[] copy = data.clone();
        long start = System.nanoTime();
        qs.sort(copy);
        long end = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(copy));
        System.out.println("Steps: " + qs.getSteps());
        System.out.println("Time (ns): " + (end - start));
    }

    private void compareAll() {
        if (checkData()) return;

        int[] copy1 = data.clone(), copy2 = data.clone(), copy3 = data.clone();

        BubbleSort bs = new BubbleSort();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();

        long startB = System.nanoTime();
        bs.sort(copy1);
        long endB = System.nanoTime();

        long startM = System.nanoTime();
        ms.sort(copy2);
        long endM = System.nanoTime();

        long startQ = System.nanoTime();
        qs.sort(copy3);
        long endQ = System.nanoTime();

        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-15s %-15s %-15s\n", "Algorithm", "Steps", "Time (ns)");
        System.out.println("--------------------------------------------");
        System.out.printf("%-15s %-15d %-15d\n", "Bubble Sort", bs.getSteps(), (endB - startB));
        System.out.printf("%-15s %-15d %-15d\n", "Merge Sort", ms.getSteps(), (endM - startM));
        System.out.printf("%-15s %-15d %-15d\n", "Quick Sort", qs.getSteps(), (endQ - startQ));
    }

    private boolean checkData() {
        if (data == null || data.length == 0) {
            System.out.println("No data available! Enter or generate numbers first.");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new DataSorterMenu().start();
    }
}
