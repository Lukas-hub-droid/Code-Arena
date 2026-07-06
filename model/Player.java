package model;


public class Player {

    private String    playerName;
    private Character character;
    private int       score;
    private int       correctAnswers;
    private int       wrongAnswers;
    private int       enemiesDefeated;

    public Player(String playerName, Character character) {
        this.playerName      = playerName;
        this.character       = character;
        this.score           = 0;
        this.correctAnswers  = 0;
        this.wrongAnswers    = 0;
        this.enemiesDefeated = 0;
    }

    public void addScore(int points)    { score += points; }
    public void registerCorrect()       { correctAnswers++; }
    public void registerWrong()         { wrongAnswers++; }
    public void registerEnemyDefeated() { enemiesDefeated++; }

    public String    getPlayerName()      { return playerName; }
    public Character getCharacter()       { return character; }
    public int       getScore()           { return score; }
    public int       getCorrectAnswers()  { return correctAnswers; }
    public int       getWrongAnswers()    { return wrongAnswers; }
    public int       getEnemiesDefeated() { return enemiesDefeated; }
}
