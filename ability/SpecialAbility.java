package ability;

import model.Character;
import question.Question;


public interface SpecialAbility {

    void use(Character user, Question question);

    String getName();

    String getDescription();

    boolean isAvailable();
}
