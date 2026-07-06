package ability;

import model.Character;
import question.Question;


public class DoubleDamageAbility implements SpecialAbility {

    private boolean used = false;

    @Override
    public void use(Character user, Question question) {
        if (used) {
            System.out.println("Dano Duplo ja foi usado nesta batalha.");
            return;
        }
        user.setDoubleDamageActive(true);
        used = true;
        System.out.println("Dano Duplo ativado! Proximo acerto causa dano dobrado.");
    }

    @Override public String  getName()        { return "Dano Duplo"; }
    @Override public String  getDescription() { return "Proximo acerto causa dano dobrado."; }
    @Override public boolean isAvailable()    { return !used; }
}
