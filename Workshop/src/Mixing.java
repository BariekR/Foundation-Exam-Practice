import java.util.*;

public class Mixing {
    public static String mix(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        s1Map = fillMap(s1, s1Map);
        s2Map = fillMap(s2, s2Map);

        List<MixingDifference> differences = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            char currentChar = (char) i;
            if (s1Map.containsKey(currentChar) && !s2Map.containsKey(currentChar)) {
                differences.add(new MixingDifference('1', currentChar, s1Map.get(currentChar)));
            } else if (!s1Map.containsKey(currentChar) && s2Map.containsKey(currentChar)) {
                differences.add(new MixingDifference('2', currentChar, s2Map.get(currentChar)));
            } else if (s1Map.containsKey(currentChar) && s2Map.containsKey(currentChar)) {
                if (s1Map.get(currentChar) > s2Map.get(currentChar)) {
                    differences.add(new MixingDifference('1', currentChar, s1Map.get(currentChar)));
                } else if (s1Map.get(currentChar) < s2Map.get(currentChar)) {
                    differences.add(new MixingDifference('2', currentChar, s2Map.get(currentChar)));
                } else {
                    differences.add(new MixingDifference('=', currentChar, s1Map.get(currentChar)));
                }
            }
        }

        Collections.sort(differences);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < differences.size(); i++) {
            sb.append(differences.get(i));
            if (i != differences.size() - 1) {
                sb.append("/");
            }
        }

        return sb.toString();
    }

    private static Map<Character, Integer> fillMap(String s, Map<Character, Integer> sMap) {
        for (char c : s.toCharArray()) {
            if (String.valueOf(c).matches("[a-z]")) {
                if (!sMap.containsKey(c)) {
                    sMap.put(c, 1);
                } else {
                    sMap.put(c, sMap.get(c) + 1);
                }
            }
        }

        Map<Character, Integer> map = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() != 1) {
                map.put(entry.getKey(), entry.getValue());
            }
        }

        return map;
    }
}
