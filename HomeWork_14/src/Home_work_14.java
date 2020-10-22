import java.util.Objects;
import java.util.Random;

public class Home_work_14 {

    private static long[] arr;
    private static int count;

    public Home_work_14(int k) {
        arr = new long[k];
        count = 0;
    }

    public void insert(long value) {
        arr[count] = value;
        count++;
    }

    public void show() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    public boolean sort() {
        if (Objects.isNull(arr)) return false;
        long x;
        for (int j = arr.length - 1; j > 1; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
        return true;
    }

    private void swap(int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isSorted() {
        for (int i = 0; i < count - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public long binarySearch(int key) {
        if (Objects.isNull(arr)) return 0;
        if (isSorted() != true) {
            return 0;
        } else {
            int lower = 0;
            int upper = count - 1;
            int middle;
            while (true) {
                middle = (lower + upper) / 2;
                if (arr[middle] == key) return middle + 1;
                else if (lower > upper)
                    return count;
                else {
                    if (arr[middle] < key)
                        lower = middle + 1;
                    else
                        upper = middle - 1;
                }
            }
        }
    }

    public boolean insertSort() {
        if (Objects.isNull(arr)) return false;

        int in, out;
        for (out = 1; out < count; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
        return true;
    }

    public long interpolationSearch(int key) {

        int left = 0;
        int right = count - 1;
        long result = 0;
        while (arr[left] < key && key < arr[right]) {
            int mid = (int) (left + (key - arr[left]) * (right - left) / (arr[right] - arr[left]));
            if (arr[mid] < key) {
                left = mid + 1;
            } else if (arr[mid] > key) {
                right = mid - 1;
            }
            if (arr[left] == key)
                result = left;
            else if (arr[right] == key)
                result = right;
            else
                result = -2;
        }
        return result + 1;
    }
}

