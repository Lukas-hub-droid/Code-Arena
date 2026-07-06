package ability;

import model.Character;
import question.Question;


public class HealAbility implements SpecialAbility {

    private boolean used   = false;
    private int     amount = 30;

    @Override
    public void use(Character user, Question question) {
        if (used) {
            System.out.println("A Cura ja foi usada nesta batalha.");
            return;
        }
        user.heal(amount);
        used = true;
        System.out.println("Cura usada! Recuperou " + amount + " de vida. Vida atual: " + user.getLife());
    }

    @Override public String  getName()        { return "Cura"; }
    @Override public String  getDescription() { return "Recupera " + amount + " pontos de vida."; }
    @Override public boolean isAvailable()    { return !used; }
}
