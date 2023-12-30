public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,0,1});
        System.out.println("ahoj");
    }

    public static void moveZeroes(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                continue;
            }
            int k = i;
            for (int j = i+1; j < nums.length; j++) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            i = k;
        }

    }
}

