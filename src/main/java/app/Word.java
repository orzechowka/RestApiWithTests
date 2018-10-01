package app;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by Anna on 2018-10-01.
 */
@Entity
@Table(name = "spanish")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    @NotBlank
    String word;

    @Column
    @NotBlank
    String translation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
