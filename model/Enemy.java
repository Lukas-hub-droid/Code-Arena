package model;


public class Enemy extends Character {

    private int level;

    public Enemy(String name, int life, int attack, int defense, int level) {
        super(name, life, attack, defense);
        this.level = level;
    }

    @Override
    public String getType() {
        return "Inimigo";
    }

    public int getLevel() {
        return level;
    }
}
