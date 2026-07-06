package model;

import ability.DoubleDamageAbility;
import ability.HealAbility;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 120, 25, 5);
        addAbility(new DoubleDamageAbility());
        addAbility(new HealAbility());
    }

    @Override
    public String getType() {
        return "Guerreiro";
    }
}
