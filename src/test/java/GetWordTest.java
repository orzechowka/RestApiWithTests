import app.Word;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;

public class GetWordTest {

    RestTemplate template;
    Word wordAdded;
    String WORD = "jeden";
    String TRANSLATION = "uno";

    @Before
    public void setUp() {
        template = new RestTemplate();
        Helper.clearDatabase();
        wordAdded = Helper.addWord(WORD, TRANSLATION);
    }

    @Test
    public void getWord() {
        long id = wordAdded.getId();
        Word wordGet = template.getForObject("http://localhost:8080/words/" + id, Word.class);
        assertEquals(wordAdded, wordGet);
    }



}
