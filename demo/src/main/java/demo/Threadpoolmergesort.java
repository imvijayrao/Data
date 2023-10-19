package demo;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Threadpoolmergesort{

    public void thread(int array[]){

        // ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        // Create a task for sorting the entire array
        Mergesort task = new Mergesort(array, 0, array.length - 1);

        // Execute the task using the thread pool
        // executor.invokeAll(Arrays.asList(task));
        // executor.shutdown();

        // Used Forkjoinpool 
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }


    public static class Mergesort extends RecursiveAction{
        private static final int threshold = 5; //threshold for parallel sorting
        
        private int[] array;
        private int low;
        private int high;

        public Mergesort(int array[], int low, int high){
            this.array = array;
            this.low = low;
            this.high = high;
        }
        
        protected void compute(){
            if(high-low <= threshold) sequentialsort();

            else{

                int mid = (low+high)/2;

                Mergesort lefttask = new Mergesort(array, low, mid);
                Mergesort righttask =  new Mergesort(array, mid+1, high);

                invokeAll(lefttask, righttask);

                merge(mid);
            }
        }

        private void sequentialsort(){
            Arrays.sort(array, low, high+1);
        }

        private void merge(int mid){
            int left[] = Arrays.copyOfRange(array, low, mid+1);
            int right[] = Arrays.copyOfRange(array, mid+1, high+1);

            int i=0,j=0,k=low;

            while(i<left.length && j<right.length){
                if(left[i] <= right[j]) array[k++] = left[i++];

                else array[k++] = right[j++];
            }

            while(i<left.length){
                array[k++] = left[i++];
            }

            while(j<right.length){
                array[k++] = right[j++];
            }
        }
    }


}