package highSort;

import java.util.ArrayList;
import java.util.Arrays;

public class quickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);

        System.out.println(pivot);

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot) {
                rightList.add(dataList.get(index));
                System.out.println(rightList);
            } else {
                leftList.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergeArr = new ArrayList<>();
        mergeArr.addAll(this.sort(leftList));
        mergeArr.addAll(Arrays.asList(pivot));
        mergeArr.addAll(this.sort(rightList));

        return mergeArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testdata = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testdata.add((int) (Math.random() * 100));
        }

        quickSort qSort = new quickSort();
        System.out.println(qSort.sort(testdata));
    }
}