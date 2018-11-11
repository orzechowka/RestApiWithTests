import app.Word;
import app.Word2;
import org.springframework.web.client.RestTemplate;

public class Helper {

    static RestTemplate template;
    static Word newWord;
    static Word2 newWord2;

    public static void clearDatabase() {
        template = new RestTemplate();
        template.delete("http://localhost:8080/words/delete");
    }

    public static Word addWord(String word, String translation) {
        newWord = new Word();
        newWord.setWord(word);
        newWord.setTranslation(translation);
        return template.postForObject("http://localhost:8080/words", newWord, Word.class);
    }

    public static Word2 addWord2(String word, String translation) {
        newWord2 = new Word2();
        newWord2.setWord(word);
        newWord2.setTranslation(translation);
        return template.postForObject("http://localhost:8080/words", newWord2, Word2.class);
    }
}
