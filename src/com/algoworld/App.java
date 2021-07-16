package com.algoworld;

import com.algoworld.searchingsorting.Search;

public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int element = 55;
        int position = Search.jump(arr, element);
        System.out.println(position==-1?"Could not find "+element:"Element "+element+" found at position "+position);
    }
}
