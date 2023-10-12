package swearwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SwearWords {
    public static void main(String[] args) {
        String[] words = {"fuck", "bloody", "cock", "shit", "fucker", "fuckstick", "asshole", "dick", "piss", "cunt"};

        System.out.println(removeSwearWords(words));
    }

    public static int removeSwearWords(String[] unpleasantWords) {
        List<String> file = new ArrayList<>();
        int removedWords = 0;

        try {
            file = Files.readAllLines(Paths.get("swearwords.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (String line : file) {
            line = line.toLowerCase();
            for (String word : unpleasantWords) {
                while (true) {
                    if (line.contains(word)) {
                        line = line.replaceFirst(word, "");
                        removedWords++;
                    } else {
                        break;
                    }
                }
            }
        }

        return removedWords;
    }
}
