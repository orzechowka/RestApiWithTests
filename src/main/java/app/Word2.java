package app;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "spanish")
public class Word2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="word")
    @NotBlank
    String word2;

    @Column(name="translation")
    @NotBlank
    String translation2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word2;
    }

    public void setWord(String word2) {
        this.word2 = word2;
    }

    public String getTranslation() {
        return translation2;
    }

    public void setTranslation(String translation2) {
        this.translation2 = translation2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word2 word21 = (Word2) o;
        return Objects.equals(word2, word21.word2) &&
                Objects.equals(translation2, word21.translation2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word2, translation2);
    }
}
