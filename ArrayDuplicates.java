import java.util.ArrayList;

public class ArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3};
        mergeSort(arr);
        for(int ele : arr) System.out.print(ele + " ");
        ArrayDuplicates obj = new ArrayDuplicates();
        System.out.println(obj.findDuplicates(arr));
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
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length; //1 to n
        int i=0; 
        while(i<n) {
            int rightIdx = arr[i] - 1;
            if(arr[i] == i+1 || arr[rightIdx] == arr[i]) i++;
            else {
                swap(arr,i,rightIdx);
            }
        }
        for(i=0; i<n; i++)  {
                if(arr[i] != i+1) ans.add(arr[i]);
            }
            return ans;
    }
    private void swap(int[] arr, int i,int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }
}
