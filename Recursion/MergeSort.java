/*
 *      Merge Sort
 * 
 *   idea(?)-> Divide & Conquer(Ha.. Ha..haaa)!
 */

public class MergeSort {

    public static void mergeSort(int arr[] , int si, int ei) {
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si)/2;    // (si+ei)/2
        mergeSort(arr, si, mid);      // left part
        mergeSort(arr, mid+1, ei);   // right part
       
        merge( arr, si, mid, ei);
    }

    public static void merge(int arr[], int si , int mid , int ei) {
        int temp[]=new int[ei-si+1];
        int i=si;    // iterator for left part
        int j=mid+1; // iterator for right part
        int k=0;     // iterator for temp arr

        while(i<=mid && j<= ei){
            if (arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //left part 
        while (i<=mid) {
            temp[k++] = arr[i++];
        }

        // right part
        while (j<=ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original arr
        for(k=0, i=si;  k<temp.length;  k++ , i++){
              arr[i]=temp[k];
        }
    }
 
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);       

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
}

/*
 *   Output:
 *   2 3 5 6 8 9
 */


/* The provided Java code implements the Merge Sort algorithm, a widely used sorting algorithm based on the "Divide and Conquer" approach. Here's a short description of the code:

1. `MergeSort` Class:
   - Contains the main Merge Sort algorithm implementation.

2. `mergeSort` Method:
   - Takes an integer array (`arr`), start index (`si`), and end index (`ei`) as input.
   - If `si` is greater than or equal to `ei`, it means there is only one element or none in the array, so no action is needed.
   - Otherwise, it calculates the middle index `mid` of the array.
   - Recursively divides the array into two halves: left part from `si` to `mid` and right part from `mid + 1` to `ei`.
   - Calls the `merge` method to merge the sorted left and right halves.

3. `merge` Method:
   - Takes an integer array (`arr`), start index (`si`), middle index (`mid`), and end index (`ei`) as input.
   - Creates a temporary integer array `temp` to hold the merged values.
   - Initializes iterators `i` for the left part, `j` for the right part, and `k` for the `temp` array.
   - Compares elements from the left and right parts and places the smaller element in the `temp` array until one of the parts is exhausted.
   - Copies any remaining elements from the left and right parts to the `temp` array.
   - Copies the elements from the `temp` array back to the original `arr` to merge the sorted parts.

4. `main` Method:
   - Initializes an integer array `arr` with unsorted values.
   - Calls the `mergeSort` method to sort the `arr` array in ascending order.
   - Prints the sorted array elements.

In summary, this code demonstrates the Merge Sort algorithm, which efficiently sorts an array by dividing it into smaller parts, sorting those parts, and then merging them back together. The output of the program is the sorted array in ascending order.  */
