public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        boolean isIncreasing = false;
        boolean isDecreasing = false;
        int peak = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                isIncreasing = true;
            } else if (arr[i-1] == arr[i]) {
                return false;
            } else {
                if(!isIncreasing) {
                    return false;
                }
                peak = i;
                break;
            }
        }

        for (int i = peak; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                isDecreasing = true;
            } else if (arr[i-1] == arr[i]) {
                return false;
            } else {
                return false;
            }
        }

        return true;
    }
}
