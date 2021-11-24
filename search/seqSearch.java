package search;

import java.util.ArrayList;

/**
 * seqSearch
 */
public class seqSearch {
    public int seqFucn(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        seqSearch seqSearch = new seqSearch();
        System.out.println(testData);
        System.out.println(seqSearch.seqFucn(testData, 50));
    }
}