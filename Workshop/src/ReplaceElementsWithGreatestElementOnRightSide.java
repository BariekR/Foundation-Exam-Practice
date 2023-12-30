public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
            max = Integer.MIN_VALUE;
        }

        return arr;
    }
}
