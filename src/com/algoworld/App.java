package com.algoworld;

import com.algoworld.searchingsorting.Search;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {10,20,30,33,40,47,50,60,69};
        int element = 69;
        int position = Search.binaryr(arr, element);
        System.out.println(position==-1?"Could not find "+element:"Element "+element+" found at position "+position);
    }
}
