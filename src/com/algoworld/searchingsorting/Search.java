package com.algoworld.searchingsorting;

public class Search {
    /**
     * Linear Search takes two parameters arr is the array and
     * element is the data that needed to be searched in the array
     * @param arr the array
     * @param element the data that needed to be searched
     * @return if found the index of the element in arr, else -1
     * @implNote Time complexity - O(n)
     * @see Search.linear2
     */
    public static int linear(int[] arr, int element){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }
        return -1;
    }
    /**
     * Linear Search takes two parameters arr is the array and
     * element is the data that needed to be searched in the array
     * @param arr the array
     * @param element the data that needed to be searched
     * @return if found the index of the element in arr, else -1
     * @implNote Time complexity - O(n/2)
     */
    public static int linear2(int[] arr, int element){
        int right = arr.length-1;
        for(int left = 0; left<=right;){
            if(arr[left]==element){
                return left;
            }
            if(arr[right]==element){
                return right;
            }
            left++;
            right--;
        }
        return -1;
    }
    /**
     * It takes a sorted array and search the specified element and returns the index if found or -1 if not found.
     * @param arr the array
     * @param element the data that needed to be searched
     * @return if found the index of element in arr, else -1
     */
    public static int binary(int[] arr, int element){
        int left = 0, right = arr.length;
        while(left<=right){
            int middle = left+(right-left)/2;
            if(arr[middle]==element)
                return middle;
            if(element>arr[middle])
                left=middle+1;
            else
                right = middle-1;
        }
        return -1;
    }

    private static int binaryRecursive(int[] arr, int left, int right, int element){
        if(right>=left){
            int mid = left+(right-left)/2;
            if(element==arr[mid])
                return mid;
            if(element>arr[mid])
                return binaryRecursive(arr, mid+1, right, element);
            return binaryRecursive(arr, left, mid-1, element);
        }
        return -1;
    }
    /**
     * It takes a sorted array and search the specified element on recursion and returns the index if found or -1 if not found.
     * @param arr the array
     * @param element the data that needed to be searched
     * @return if found the index of element in arr, else -1
     */
    public static int binaryr(int[] arr, int element){
        return binaryRecursive(arr, 0, arr.length-1, element);
    }
}
