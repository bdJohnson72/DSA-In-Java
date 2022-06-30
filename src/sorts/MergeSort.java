package sorts;

public class MergeSort {

    public static void mergeSort(int[] nums, int length){
        if(length < 2) {return;}

        int mid = length /2;
        //get to new arrays half the size of the original
        int[] left = new int[mid];
        int[] right = new int[mid];

        //copy to left
        for(int i = 0; i < mid; i++){
            left[i] = nums[i];
        }
        //copy to right
        for (int i = mid; i < length ; i ++) {
            right[i - mid] = nums[i];
        }

        //make recursive calls
        mergeSort(left, mid);
        mergeSort(right, length - mid);
        merge(nums, left, right, mid, length - mid);
    }

    public static void merge(int[] nums, int[] left, int[] right, int leftSize, int rightSize){
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize){
            if (left[i] < right[k]){
                nums[k++] = left[i++];
            }else {
                nums[k++] = right[j++];
            }
        }

        //add on what is left over
        while(i < leftSize){
            nums[k++] = left[i++];
        }
        while(j < rightSize){
            nums[k++] = right[j++];
        }
    }
}
