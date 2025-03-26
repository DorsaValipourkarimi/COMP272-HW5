
/******************************************************************
 *
 *   Dorsa Valipourkarimi / COMP 272 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        // Create a HashSet to store all elements from list1
        HashSet<Integer> set = new HashSet<>();

        // Add every number from list1 to the set
        for (int n : list1) {
            set.add(n);
        }
        // Check if every number in list2 exists in the set
        for (int n : list2) {
            if (!set.contains(n)) { // If not
                return false; // Not a subset
            }
        }

        return true; // Otherwise, it is a subset
    }

    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     * Input: [1,7,3,10,34,5,8], 4
     * Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        // MinHeap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : array) { // Loop through the array
            minHeap.add(n); // Add each element to the heap
            if (minHeap.size() > k) { // If the heap has more than k elements
                minHeap.poll(); // Remove the smallest (root)
            }
        }
        // Return the top of the heap (aka k-th largest element)
        return minHeap.peek();
    }

    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     * Input: [4,1,5], [3,2]
     * Output: 1 2 3 4 5
     *
     * @param array1 - Input array 1
     * @param array2 - Input array 2
     * @return - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        // MinHeap to store and automatically sort all elements
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        // Insert all elements from array1 into the heap
        for (int n : array1) {
            temp.add(n);
        }
        // Insert all elements from array2 into the heap
        for (int n : array2) {
            temp.add(n);
        }
        // Create a result array to hold the sorted output
        int[] result = new int[array1.length + array2.length];
        int index = 0;
        // Restore elements in the result array from the heap in order
        while (!temp.isEmpty()) {
            result[index++] = temp.poll();
        }
        // Return the result
        return result;
    }

}