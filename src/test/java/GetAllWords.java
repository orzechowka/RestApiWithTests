import app.Word;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GetAllWords {

    RestTemplate template;

    @Before
    public void setUp() {
        template = new RestTemplate();
        Helper.clearDatabase();
        Helper.addWord("jeden", "uno");
        Helper.addWord("dwa", "dos");
        Helper.addWord("trzy", "tres");
    }
    
    @Test
    public void getAllWords() {
        List<Word> foundWords = Arrays.asList(template.getForEntity("http://localhost:8080/words", Word[].class).getBody());
        assertEquals(3, foundWords.size());
    }
}
