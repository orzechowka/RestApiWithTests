import app.Word;
import app.Word2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@Component
public class AddWordTest {

    @Autowired
    RestTemplate template;
    Word word;
    Word2 word2;
    String WORD = "jeden";
    String TRANSLATION = "uno";
    String WORD_2 = "dwa";
    String TRANSLATION_2 = "dos";

    @Before
    public void setUp() {
        template = new RestTemplate();
        Helper.clearDatabase();
        word = Helper.addWord(WORD, TRANSLATION);
        word2 = Helper.addWord2(WORD_2, TRANSLATION_2);
    }

    @Test
    public void addWord() {
        ResponseEntity<Word> wordResponseEntity = template.postForEntity("http://localhost:8080/words", word, Word.class);
        Word addedWord = wordResponseEntity.getBody();
        assertEquals(word.getWord(), addedWord.getWord());
        assertEquals(word.getTranslation(), addedWord.getTranslation());
    }

    @Test
    public void addWord2() {
        Word2 wordAdded = template.postForObject("http://localhost:8080/words", word2, Word2.class);
        assertEquals(word2, wordAdded);
    }

    @Test
    public void addWord21() {
        Word2 wordAdded = template.postForObject("http://localhost:8080/words", word2, Word2.class);
        assertEquals(word2, wordAdded);
    }

}
