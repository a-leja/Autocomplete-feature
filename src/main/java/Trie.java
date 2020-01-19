import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Trie {
    private TrieNode root;
    static Scanner input = new Scanner(System.in);
    static String prefix;

    public Trie() {
        root = new TrieNode( ' ');
    }

    public void insert(String word) {

        TrieNode current = root;
        TrieNode previous;

        for (char c : word.toLowerCase().toCharArray()) {
            previous = current;
            TrieNode child = current.getChild(c);

            if (child != null) {
                current = child;
                child.parent = previous;
            } else {
                current.children.add(new TrieNode(c));
                current = current.getChild(c);
                current.parent = previous;
            }
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (current.getChild(c) == null) {
                return false;
            } else {
                current = current.getChild(c);
            }
        }

        if (current.isEnd == true) {
            return true;
        }
        return false;
    }

    public static String getPrefix() {
        prefix = input.nextLine();
        return prefix;
    }

    public List<String> autocomplete(String prefix) {
        TrieNode lastNode = root;
        for (int i = 0; i< prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return new ArrayList<>();

            }
        }
        return lastNode.getWords().stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
    }
}
