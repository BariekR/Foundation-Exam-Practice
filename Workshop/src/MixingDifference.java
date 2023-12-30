public class MixingDifference implements Comparable<MixingDifference> {
    private char from;
    private char letter;
    private int letterCount;

    public MixingDifference(char from, char letter, int letterCount) {
        this.from = from;
        this.letter = letter;
        this.letterCount = letterCount;
    }

    @Override
    public String toString() {
        return from + ":" + String.valueOf(letter).repeat(letterCount);
    }

    @Override
    public int compareTo(MixingDifference o) {
        int result = Integer.compare(o.letterCount, letterCount);
        if (result == 0) {
            result = Character.compare(from, o.from);
        }
        if (result == 0) {
            result = Character.compare(letter, o.letter);
        }
         return result;
    }
}
