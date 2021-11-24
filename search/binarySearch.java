package search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * binarySearch
 */
public class binarySearch {
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)) {
            return true;
        } else {
            if (dataList.get(medium) > searchItem) {
                return this.searchFunc(new ArrayList<>(dataList.subList(0, medium)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        binarySearch bSearch = new binarySearch();

        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        Collections.sort(testData);
        System.out.println(testData);
        System.out.println(bSearch.searchFunc(testData, 20));
    }
}