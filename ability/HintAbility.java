package ability;

import model.Character;
import question.MultipleChoiceQuestion;
import question.Question;


public class HintAbility implements SpecialAbility {

    private boolean used = false;

    @Override
    public void use(Character user, Question question) {
        if (used) {
            System.out.println("A Dica ja foi usada nesta batalha.");
            return;
        }
        if (question instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
            mcq.eliminateAlternative();
            used = true;
            System.out.println("Dica usada! Uma alternativa errada foi eliminada.");
        } else {
            System.out.println("A Dica so funciona em questoes de multipla escolha.");
        }
    }

    @Override public String  getName()        { return "Dica"; }
    @Override public String  getDescription() { return "Elimina uma alternativa errada."; }
    @Override public boolean isAvailable()    { return !used; }
}
