package mergesort;

public class SortAnArray {
    public static void merge(int[] array, int left, int middle, int right) {
        int length1 = middle - left + 1;
        int length2 = right - middle;

        int[] leftArray = new int[length1];
        int[] rightArray = new int[length2];

        for (int i = 0; i < length1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < length2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < length1 && j < length2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < length1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < length2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public int[] mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }

        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);

        merge(array, start, middle, end);
        return array;
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
