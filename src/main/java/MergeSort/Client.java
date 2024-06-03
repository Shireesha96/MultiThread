package MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws Exception {
        List<Integer> list =  List.of(1, 3,2,6,3,6,8,9,5,3,0);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter merge = new Sorter(list, executorService);

        Future<List<Integer>> sortedFuture = executorService.submit(merge);

        List<Integer> sortedList = sortedFuture.get();
        System.out.println(sortedList);
        executorService.shutdown();
    }
}
