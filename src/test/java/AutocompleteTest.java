import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AutocompleteTest {

    @Test
    public void autocompleteTest() {
        //Given
        Trie t = new Trie();
        t.insert("Intelligence");
        t.insert("Internet");
        t.insert("Integration");
        t.insert("International");
        t.insert("Intellectual");
        t.insert("Intermediary");
        //When
        String prefix = "inte";
        List<String> result = t.autocomplete(prefix);
        //Then
        assertEquals(4, result.size());
        assertEquals("integration", result.get(0));
    }
}
