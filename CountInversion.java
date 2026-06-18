public class CountInversion {
    static int count;
    public static int inversionCount(int[] arr) {
        count = 0;
        mergeSort(arr);
        return count;
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
            else {
                count += (a.length-i);
                c[k++] = b[j++];
            }
        }
        while(i<a.length) c[k++] = a[i++];
        while(j<b.length) c[k++] = b[j++];
    }
}
