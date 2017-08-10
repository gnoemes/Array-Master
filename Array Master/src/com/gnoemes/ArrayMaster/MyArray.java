package com.gnoemes.ArrayMaster;

import java.util.*;

public class MyArray {
    private List<Integer> array = new ArrayList<>();
    private int maxSize;
    private float timeSortConsumed;
    private float timeSearchConsumed;
    private String lastSortType ="";
    private String lastSearchType = "";

    public MyArray(int maxSize) {
        this.maxSize = maxSize;
    }

    public void fillArray() {
        Random rnd = new Random();
        for (int i = 0; i < maxSize; i++)
            array.add(rnd.nextInt(maxSize + rnd.nextInt(maxSize /2)) + 1);
    }

    public void reverse() {
        Collections.reverse(array);
    }

    public void shuffle() {
        Collections.shuffle(array);
    }

    public void addElem(int num) {
        array.add(num);
    }

    public void removeElem(int index) {array.remove(index);}

    public boolean isSorted() {
        boolean reverse = false;
        for (int i = 1; i < array.size();i++)
            if (array.get(i-1) > array.get(i)) reverse = true;
        if (reverse)
        for (int i = 1; i < array.size(); i++) {
             if (array.get(i-1) < array.get(i)) return false;
        }

        return true;
    }

    public void bubbleSort() {
        long start = System.nanoTime();
        for (int i = array.size()-1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                 if (array.get(j) > array.get(j + 1)) {
                     int tmp = array.get(j);
                     array.remove(j);
                     array.add(j+1,tmp);
                 }
            }

        }
        lastSortType = "Bubble";
        long finish = System.nanoTime();
        timeSortConsumed = (float) ((float) (finish - start) * 0.000001);
    }

    public void quickSort() {
        long start = System.nanoTime();
        Collections.sort(array);
        lastSortType = "Quick";
        long finish = System.nanoTime();
        timeSortConsumed = (float) ((float) (finish - start) * 0.000001);
    }

    public void insertionSort() {
        long start = System.nanoTime();
        for (int i = 0; i < array.size(); i++)
            for (int j = i; j > 0 && array.get(j-1) > array.get(j); j--) {
                int tmp = array.get(j-1);
                array.remove(j-1);
                array.add(j,tmp);
            }

        lastSortType = "Insertion";
        long finish = System.nanoTime();
        timeSortConsumed = (float) ((float) (finish - start) * 0.000001);
    }

    public void selectionSort() {
        long start = System.nanoTime();

        int min;
        for (int index = 0; index < array.size()-1; index++){
            min = index;
            for (int scan = index+1; scan < array.size(); scan++){
                if (array.get(scan) < array.get(min))
                    min = scan;
            }
            int tmp = array.get(min);
            array.remove(min);
            array.add(min,array.get(index));
            array.set(index,tmp);
        }

        lastSortType = "Selection";
        long finish = System.nanoTime();
        timeSortConsumed = (float) ((float) (finish - start) * 0.000001);
    }

    public int linearSearch(int n) {
        int index = -1;
        long start = System.nanoTime();
        for (int i = 0; i < array.size(); i++)
            if (array.get(i) == n) {
            index = i;
            break;
        }
        lastSearchType = "Linear";
        long finish = System.nanoTime();
        timeSearchConsumed = (float) ((float) (finish - start) * 0.000001);
        return index;
    }

    public int binarySearch(int n) {
        long start = System.nanoTime();
        int index = -1;
        int left = 0;
        int right = array.size();
        while (left < right) {
            int cur = (right + left) / 2;
            if (array.get(cur) == n) {
                index = cur;
                break;
            }
            else {
                if (array.get(cur) > n) right = cur;
                else left = ++cur;
            }
        }
        lastSearchType = "Binary";
        long finish = System.nanoTime();
        timeSearchConsumed = (float) ((float) (finish - start) * 0.000001);
        System.out.println(index);
        return index;
    }

    public String toString() {
        return array.toString();
    }

    public String getSize() {
        return String.valueOf(array.size());
    }

    public int getMax() {
        return Collections.max(array);
    }

    public int getMin() {
        return Collections.min(array);
    }

    public int getLast() {
        return array.get(array.size()-1);
    }

    public int getFirst() {
        return array.get(0);
    }

    public float getTimeSortConsumed() {
        return timeSortConsumed;
    }

    public float getTimeSearchConsumed() {
        return timeSearchConsumed;
    }

    public String getLastSortType() {
        return lastSortType;
    }

    public String getLastSearchType() {
        return lastSearchType;
    }
}
