import app.Word;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Anna on 2018-10-01.
 */
public class Test {

@org.junit.Test
public void test() {

    RestTemplate template = new RestTemplate();
    Word word = new Word();
    word.setWord("jeden");
    word.setTranslation("uno");
    ResponseEntity<Word> wordResponseEntity = template.postForEntity("http://localhost:8080/words", word, Word.class);

}

}
