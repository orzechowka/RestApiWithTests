import app.Word;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anna on 2018-10-01.
 */
@Component
public class AddWordTest {

    @Autowired
    RestTemplate template;
    Word word;

    @Before
    public void setUp() {
        template = new RestTemplate();
        template.delete("http://localhost:8080/words/delete");
        word = new Word();
        word.setWord("jeden");
        word.setTranslation("uno");
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
        Map<String, String> map = new HashMap<>();
        map.put("String", "String");
        ResponseEntity<Word> wordResponseEntity = template.postForEntity("http://localhost:8080/words", word, Word.class, map);
        wordResponseEntity.getStatusCode();
    }

}
