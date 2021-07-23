package com.algoworld;

import com.algoworld.searchingsorting.Search;

public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
            22, 23, 24, 33, 35, 42, 47 };
        int element = 13;
        int position = Search.ternary(arr, element);
        System.out.println(position==-1?"Could not find "+element:"Element "+element+" found at position "+position);
    }
}
