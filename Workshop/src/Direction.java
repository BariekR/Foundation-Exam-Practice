import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Direction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
    }
    public static String[] dirReduc(String[] arr) {
        int i = 0;
        int zeroCount = 0;
        while (i + 1 < arr.length) {
            if (arr[i].equals("NORTH") && arr[i+1].equals("SOUTH") ||
                arr[i].equals("SOUTH") && arr[i+1].equals("NORTH") ||
                arr[i].equals("WEST") && arr[i+1].equals("EAST") ||
                arr[i].equals("EAST") && arr[i+1].equals("WEST"))
            {
                arr[i] = "0";
                arr[i+1] = "0";
                zeroCount += 2;
            }
            i++;
        }

        List<String> output = new ArrayList<>();
        for (String dir : arr) {
            if (!dir.equals("0")) {
                output.add(dir);
            }
        }

        if (zeroCount > 0) {
            return dirReduc(output.toArray(new String[0]));
        }
        return output.toArray(new String[0]);

    }
}
