package ability;

import model.Character;
import question.Question;


public class ShieldAbility implements SpecialAbility {

    private boolean used = false;

    @Override
    public void use(Character user, Question question) {
        if (used) {
            System.out.println("O Escudo ja foi usado nesta batalha.");
            return;
        }
        user.setShieldActive(true);
        used = true;
        System.out.println("Escudo ativado! Proximo erro nao causara dano.");
    }

    @Override public String  getName()        { return "Escudo"; }
    @Override public String  getDescription() { return "Bloqueia o dano do proximo erro."; }
    @Override public boolean isAvailable()    { return !used; }
}
