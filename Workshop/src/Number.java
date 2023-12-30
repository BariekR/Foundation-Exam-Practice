import java.util.ArrayList;
import java.util.List;

public class Number {
    public static void main(String[] args) {

        System.out.println(solve(999999999999999999L));
        System.out.println(solve(1000000000000000000L));
        System.out.println(solve(999999999999999993L));
    }

    public static int solve(long n){
        long numberOfDigits = 1L;
        byte adder = 1;
        int numberAdded = 1;
        int counterLimit = 10;
        long totalDigits = 1L;

        while (totalDigits < n) {
            numberAdded++;
            if(numberAdded == counterLimit) {
                adder++;
                counterLimit *= 10;
            }
            numberOfDigits += adder;
            totalDigits += numberOfDigits;
        }

        while (totalDigits != n) {
            int lengthOfLast = String.valueOf(numberAdded).length();
            if (totalDigits - lengthOfLast < n) {
                String last = String.valueOf(numberAdded);
                return Character.getNumericValue(last.charAt(last.length() - 1 - (int)(totalDigits - n)));
            }

            totalDigits -= lengthOfLast;
            numberAdded--;
        }

        return Character.getNumericValue(String.valueOf(numberAdded).charAt(String.valueOf(numberAdded).length() - 1));
    }
}
