public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        for(int i=0; i<k; i++) {
            int min = Integer.MIN_VALUE, minIdx = -1;
            for(int j=1; j<n; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        return arr[k-1];
    }
}
