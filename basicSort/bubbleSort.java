package basicSort;

import java.util.ArrayList;
import java.util.Collections;

public class bubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < dataList.size() - i - 1; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }

            if (swap == false) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        bubbleSort bSort = new bubbleSort();
        System.out.println(bSort.sort(testData));
    }
}