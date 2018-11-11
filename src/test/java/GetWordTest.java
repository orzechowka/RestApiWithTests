import app.Word;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;

public class GetWordTest {

    RestTemplate template;
    Word newWord;
    Word wordAdded;
    String WORD = "jeden";
    String TRANSLATION = "uno";

    @Before
    public void setUp() {
        template = new RestTemplate();
        clearDatabase();
        addWord(WORD, TRANSLATION);
    }

    @Test
    public void getWord() {
        long id = wordAdded.getId();
        Word wordGet = template.getForObject("http://localhost:8080/words/" + id, Word.class);
        assertEquals(wordAdded, wordGet);
    }


    private void clearDatabase() {
        template.delete("http://localhost:8080/words/delete");
    }

    private void addWord(String word, String translation) {
        newWord = new Word();
        newWord.setWord(word);
        newWord.setTranslation(translation);
        wordAdded = template.postForObject("http://localhost:8080/words", newWord, Word.class);
    }
}
