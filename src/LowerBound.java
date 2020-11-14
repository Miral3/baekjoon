public class LowerBound {
    public static void main(String[] args) {
        int arr[] = {3};
        int target = 2;
        System.out.println(lowerBound(arr, 1, target));
    }

    public static int lowerBound(int arr[],int end, int target) {
        int start = 0;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
