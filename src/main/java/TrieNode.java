import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrieNode {
    char data;
    TrieNode parent;
    LinkedList<TrieNode> children;
    boolean isEnd;

    public TrieNode(char c) {
        data = c;
        children = new LinkedList<>();
        isEnd = false;
    }

    //search for a child node by the character
    public TrieNode getChild(char c) {
        if (children != null) {
            for (TrieNode child : children) {
                if (child.data == c) {
                    return child;
                }
            }
        }
        return null;
    }

    //find all the words associated with the node
    protected List<String> getWords() {
        List<String> listOfWords = new ArrayList<>();
        if (isEnd) {
            listOfWords.add(toString());
        }

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i) != null) {
                    listOfWords.addAll(children.get(i).getWords());
                }
            }
        }
        return listOfWords;
    }

    public String toString() {
        if (parent == null) {
            return "";
        } else {
            return parent.toString() + new String(new char[]{data});
        }
    }
}
