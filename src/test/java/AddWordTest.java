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

    @Before
    public void setUp() {
        template = new RestTemplate();
        template.delete("http://localhost:8080/words/delete");
        word = new Word();
        word.setWord("jeden");
        word.setTranslation("uno");

        word2 = new Word2();
        word2.setWord("dwa");
        word2.setTranslation("dos");
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
        Word wordAdded = template.postForObject("http://localhost:8080/words", this.word, Word.class);
        assertEquals(word, wordAdded);

    }

    @Test
    public void addWord21() {
        Word2 wordAdded = template.postForObject("http://localhost:8080/words", this.word2, Word2.class);
        assertEquals(word2, wordAdded);

    }

}
