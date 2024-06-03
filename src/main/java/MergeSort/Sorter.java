package MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arraySort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arraySort, ExecutorService executorService) {
        this.arraySort = arraySort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println(Thread.currentThread().getName());

        if(arraySort.size() <= 1){
            return arraySort;
        }

        int mid = arraySort.size()/2;

        List<Integer> leftArray = new ArrayList<>(arraySort.subList(0, mid));
        List<Integer> rightArray = new ArrayList<>(arraySort.subList(mid, arraySort.size()));

        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);

        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);

        List<Integer> leftSortedArray = leftFuture.get();
        List<Integer> rightSortedArray = rightFuture.get();

        List<Integer> sortedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if(leftSortedArray.get(i) < rightSortedArray.get(j)) {
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }
            else {
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i < leftSortedArray.size()) {
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j < rightSortedArray.size()) {
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }

        return sortedArray;
    }
}
