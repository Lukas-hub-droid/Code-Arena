package model;

import ability.HintAbility;
import ability.ShieldAbility;


public class Sage extends Character {

    public Sage(String name) {
        super(name, 140, 15, 10);
        addAbility(new HintAbility());
        addAbility(new ShieldAbility());
    }

    @Override
    public String getType() {
        return "Sabio";
    }
}
