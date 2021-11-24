package basicSort;

import java.util.Collections;
import java.util.ArrayList;

public class insertSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inSort = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            inSort.add((int) (Math.random() * 100));
        }
        insertSort insertsort = new insertSort();
        System.out.println(inSort);
        System.out.println(insertsort.sort(inSort));
    }
}
