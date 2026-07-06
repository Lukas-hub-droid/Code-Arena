package model;

import ability.SpecialAbility;


public abstract class Character {

    protected String name;
    protected int    life;
    protected int    maxLife;
    protected int    attack;
    protected int    defense;


    private boolean shieldActive       = false;
    private boolean doubleDamageActive = false;


    private SpecialAbility[] abilities;
    private int              abilityCount = 0;

    public Character(String name, int life, int attack, int defense) {

        if (life <= 0) {
            throw new IllegalArgumentException("Vida inicial deve ser maior que zero.");
        }

        this.name      = name;
        this.life      = life;
        this.maxLife   = life;
        this.attack    = attack;
        this.defense   = defense;
        this.abilities = new SpecialAbility[2];
    }


    public abstract String getType();





    public int takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Dano não pode ser negativo.");
        }

        int minimumDamage = Math.max(1, damage / 4);
        int reduced       = damage - (defense / 2);
        int actualDamage  = Math.max(minimumDamage, reduced);

        life = Math.max(0, life - actualDamage);
        return actualDamage;
    }

    public void heal(int amount) {
        life = Math.min(maxLife, life + amount);
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void addAbility(SpecialAbility ability) {
        if (abilityCount < abilities.length) {
            abilities[abilityCount] = ability;
            abilityCount++;
        }
    }



    public String           getName()              { return name; }
    public int              getLife()              { return life; }
    public int              getMaxLife()           { return maxLife; }
    public int              getAttack()            { return attack; }
    public int              getDefense()           { return defense; }
    public SpecialAbility[] getAbilities()         { return abilities; }
    public int              getAbilityCount()      { return abilityCount; }

    public boolean isShieldActive()               { return shieldActive; }
    public void    setShieldActive(boolean v)     { this.shieldActive = v; }

    public boolean isDoubleDamageActive()         { return doubleDamageActive; }
    public void    setDoubleDamageActive(boolean v){ this.doubleDamageActive = v; }

    @Override
    public String toString() {
        return getType() + " " + name +
               " | Vida: " + life + "/" + maxLife +
               " | Ataque: " + attack +
               " | Defesa: " + defense;
    }
}
