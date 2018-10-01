package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Anna on 2018-10-01.
 */

@RestController
public class Controller {

    @Autowired
    public WordRepository wordRepository;

    @ResponseBody
    @GetMapping("/words")
    public Iterable<Word> getWords() {
        return wordRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/words/{id}")
    public Optional<Word> getWord(@PathVariable(value = "id") long id) {
        return wordRepository.findById(id);
    }

    @ResponseBody
    @PostMapping("/words")
    public Word putWord(@Valid @RequestBody Word word) {
        return wordRepository.save(word);
    }
}
