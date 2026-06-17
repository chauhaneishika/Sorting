//1. Make 2 new empty arrays of size n/2 each & copy paste arr elements to them
//2. one arr is of n/2 size & other one will be of n-n/2
//3. then sort both of them by magic
//4. now combine both parts into one sorted array

public class MergeSortUsingMagic {
    public static void main(String[] args) {
        int[] arr = {5,2,8,4,1,6,7,3};
        mergeSort(arr);
        for(int ele : arr) System.out.print(ele + " ");
    }
    private static void mergeSort(int[] arr){
        int n = arr.length;
        if(n == 1) return; //1 length arr is already sorted
        // two empty arrays
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        //copy-paste arr into a and b
        int idx = 0; //idx travel krega arr pe
        for(int i=0; i<a.length; i++){
            a[i] = arr[idx++];
        }
        for(int j=0; j<b.length; j++) {
            b[j] = arr[idx++];
        }
        //magic
        mergeSort(a);
        mergeSort(b);
        //merge a and b into arr
        merge(a,b,arr);
    }
    public static void merge(int[] a, int[] b, int[] c) {
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length) {
            if(a[i]<=b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while(i<a.length) c[k++] = a[i++];
        while(j<b.length) c[k++] = b[j++];
    }
}
