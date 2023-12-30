import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a,b) -> Integer.compare(a % 2, b % 2))
                .mapToInt(i -> i)
                .toArray();
    }
}
