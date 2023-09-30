/*merge sort array
You are given K sorted arrays, each with N elements. Implement a function to merge them into a single sorted array.
*/
import java.util.*;

public class MergeKSortedArrays {

    public static int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int totalLength = 0;

        // Add the first element from each array to the min heap.
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null && arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0});
                totalLength += arrays[i].length;
            }
        }

        int[] result = new int[totalLength];
        int currentIndex = 0;

        while (!minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            int value = min[0];
            int arrayIndex = min[1];
            int elementIndex = min[2];

            result[currentIndex++] = value;

            // If there's a next element in the same array, add it to the heap.
            if (elementIndex < arrays[arrayIndex].length - 1) {
                minHeap.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[] mergedArray = mergeKSortedArrays(arrays);

        System.out.println("Merged Sorted Array:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
