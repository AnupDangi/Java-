import java.util.*;

class WordLadder { //0(n*2*m)
    // Function to find the shortest transformation chain length from start to target
    static int shortestChainLen(String start, String target, Set<String> D) {
        // If start and target are the same, no transformation is needed
        if (start.equals(target)) return 0;

        // If target word is not in the dictionary, return 0 as transformation is impossible
        if (!D.contains(target)) return 0;

        int level = 0; // Represents the number of transformations needed
        int wordLength = start.length(); // Length of each word (assuming all words are the same length)
        Queue<String> Q = new LinkedList<>(); // Queue to perform BFS
        Q.add(start); // Start BFS from the start word

        // BFS to find the shortest transformation sequence
        while (!Q.isEmpty()) {
            ++level; // Increment level at the start of each BFS layer
            int sizeOfQ = Q.size(); // Number of words to process at the current level

            // Process all words at the current BFS level
            for (int i = 0; i < sizeOfQ; ++i) {
                // Get the current word from the queue and convert it to a char array
                char[] word = Q.peek().toCharArray();
                Q.remove();

                // Try changing each character of the current word
                for (int pos = 0; pos < wordLength; ++pos) {
                    char orig_char = word[pos]; // Save the original character

                    // Replace the character at position `pos` with every letter from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; ++c) {
                        word[pos] = c;
                        String newWord = String.valueOf(word); // Form the new word after substitution

                        // If the new word is the target, return the current level + 1 (final transformation)
                        if (newWord.equals(target)) return level + 1;

                        // If the new word is in the dictionary, add it to the queue for further processing
                        if (D.contains(newWord)) {
                            D.remove(newWord); // Remove the new word from the dictionary to avoid revisiting
                            Q.add(newWord); // Add the new word to the queue
                        }
                    }

                    // Restore the original character at position `pos` to try other transformations
                    word[pos] = orig_char;
                }
            }
        }

        // If the target word was not reachable, return 0
        return 0;
    }

    public static void main(String[] args) {
        // Define the dictionary set with allowed transformations
        Set<String> D = new HashSet<>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");

        String start = "toon"; // Starting word
        String target = "plea"; // Target word

        // Find and print the length of the shortest transformation chain
        System.out.print("Length of shortest chain is: " + shortestChainLen(start, target, D));
    }
}
