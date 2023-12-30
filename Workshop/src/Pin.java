import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pin {

    static HashMap<Character, List<Character>> adjacent;

    static {
        adjacent = new HashMap<>();
        adjacent.put('1', new ArrayList<>(Arrays.asList('1','2','4')));
        adjacent.put('2', new ArrayList<>(Arrays.asList('2','1','3','5')));
        adjacent.put('3', new ArrayList<>(Arrays.asList('3','2','6')));
        adjacent.put('4', new ArrayList<>(Arrays.asList('4','1','5','7')));
        adjacent.put('5', new ArrayList<>(Arrays.asList('5','2','4','6','8')));
        adjacent.put('6', new ArrayList<>(Arrays.asList('6','3','5','9')));
        adjacent.put('7', new ArrayList<>(Arrays.asList('7','4','8')));
        adjacent.put('8', new ArrayList<>(Arrays.asList('8','5','7','9','0')));
        adjacent.put('9', new ArrayList<>(Arrays.asList('9','6','8')));
        adjacent.put('0', new ArrayList<>(Arrays.asList('0','8')));
    }
    public static List<String> getPINsT(String observed) {
        List<String> output = new ArrayList<>();
        List<List<Character>> padlock = new ArrayList<>();
        for (int i = 0; i < observed.length(); i++) {
            padlock.add(adjacent.get(observed.charAt(i)));
        }

        StringBuilder sb = new StringBuilder("000");
        getPIN(padlock,0,observed.length(),output,sb);
        return output;
    }
    public static void getPIN(List<List<Character>> padlock,int index, int observedLength,List<String> output ,StringBuilder sb) {
        List<Character> chars = padlock.get(index);

        for (Character aChar : chars) {
            sb.replace(index, index + 1, String.valueOf(aChar));
            if (index != observedLength - 1) {
                getPIN(padlock, index + 1, observedLength, output, sb);
            } else {
                output.add(sb.toString());
            }
        }
    }

    public static List<String> getPINs(String observed) {
        List<List<Character>> padlock = new ArrayList<>();
        for (int i = 0; i < observed.length(); i++) {
            padlock.add(adjacent.get(observed.charAt(i)));
        }

        List<String> output = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> indices = new ArrayList<>();
        for (int l = 0; l < observed.length(); l++) {
            indices.add(0);
        }

        boolean run = true;
        while (run) {
            StringBuilder sb = new StringBuilder();

            for (int l = 0; l < indices.size(); l++) {
                sb.append(padlock.get(l).get(indices.get(l)));
            }

            output.add(sb.toString());
            for (int l = indices.size() - 1; l >= 0; l--) {
                indices.set(l, indices.get(l) + 1);

                if (l == 0 && indices.get(l) == padlock.get(0).size()){
                    run = false;
                    break;
                }

                if (indices.get(l) == padlock.get(l).size()) {
                    indices.set(l, 0);
                } else {
                    break;
                }
            }
            /*
            k++;
            if (k == padlock.get(2).size()) {
                k = 0;
                j++;
                if (j == padlock.get(1).size()) {
                    j = 0;
                    i++;
                    if (i == padlock.get(0).size()) {
                        break;
                    }
                }
            }
            */
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println("Ramez");
        System.out.println(getPINs("13789"));
        System.out.println("Tereza");
        System.out.println(getPINsT("13789"));
    }

}
