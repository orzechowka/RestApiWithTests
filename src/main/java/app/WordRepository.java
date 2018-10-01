package app;

import app.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anna on 2018-10-01.
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {


}
