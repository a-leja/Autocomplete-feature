import java.util.List;

public class Words {

    public void showAvailableWords() {
        Trie t = new Trie();
        t.insert("Pandora");
        t.insert("Pinterest");
        t.insert("Paypal");
        t.insert("Pg&e");
        t.insert("Project free tv");
        t.insert("Priceline");
        t.insert("Press democrat");
        t.insert("Progressive");
        t.insert("Project runway");
        t.insert("Proactive");
        t.insert("Programming");
        t.insert("Progeria");
        t.insert("Progesterone");
        t.insert("Progenex");
        t.insert("Procurable");
        t.insert("Processor");
        t.insert("Proud");
        t.insert("Print");
        t.insert("Prank");
        t.insert("Bowl");
        t.insert("Owl");
        t.insert("River");
        t.insert("Phone");
        t.insert("Kayak");
        t.insert("Stamps");
        t.insert("Reprobe");

        List<String> list = t.autocomplete(Trie.getPrefix().toLowerCase());
        list.stream().forEach(System.out::println);
    }
}
