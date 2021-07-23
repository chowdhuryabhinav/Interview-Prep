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
            System.out.println(mid);
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

    public static int jump(int[] arr, int element){
        int n = arr.length;
        int step = (int)Math.floor(Math.sqrt(n));
        int prev = 0;
        while (arr[Math.min(step, n)-1]<element) {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if(prev>=n)
                return -1;
        }

        while (arr[prev]<element) {
            prev++;
            if(prev == Math.min(step, n))
                return -1;
        }

        if(arr[prev]==element)
            return prev;
            
        return -1;
    }

    private static int interpolation(int[] arr, int element, int hi, int lo){
        if(lo<=hi && element<=arr[hi] && element>=arr[lo]){
            int pos = lo + (((hi-lo)*(element-arr[lo])) / (arr[hi]-arr[lo]));
            if(arr[pos]==element)
                return pos;
            if(arr[pos]>element)
                return interpolation(arr, element, pos-1, lo);
            if(arr[pos]<element)
                return interpolation(arr, element, hi, pos+1);
        }
        return -1;
    }

    public static int interpolation(int[] arr, int element){
        return interpolation(arr, element, arr.length-1, 0);
    }
    public static int exponential(int[] arr, int element){
        if(element == arr[0])
            return 0;
        int i = 1;
        int n = arr.length;
        while(i < n && arr[i]<=element){
            i *= 2;
        }
        return binaryRecursive(arr, i/2, Math.min(i,n-1), element);
    }

    private static int ternary(int[] arr, int element, int left, int right){
        if(right>=left){
            int mid1 = left + (right-left) / 3;
            int mid2 = mid1 + (right-left) / 3;
            if(arr[mid1]==element)
                return mid1;
            if(arr[mid2]==element)
                return mid2;
            if(element<arr[mid1])
                return ternary(arr, element, left, mid1-1);
            if(element>arr[mid2])
                return ternary(arr, element, mid2+1, right);
            return ternary(arr, element, mid1+1, mid2-1);
        }
        return -1;
    }
    public static int ternary(int[] arr, int element){
        return ternary(arr, element, 0, arr.length-1);
    }
}
