package battle;

import model.Enemy;
import model.Player;
import question.Question;
import question.QuestionBank;

import java.util.Scanner;


public class BattleManager {

    private Player       player;
    private Enemy        enemy;
    private QuestionBank questionBank;
    private Scanner      scanner;

    public BattleManager(Player player, Enemy enemy,
                          QuestionBank questionBank, Scanner scanner) {
        this.player       = player;
        this.enemy        = enemy;
        this.questionBank = questionBank;
        this.scanner      = scanner;
    }


    public boolean run() {
        System.out.println("\n==========================================");
        System.out.println(" " + player.getCharacter().getName() +
                           " vs " + enemy.getName() +
                           " (Nivel " + enemy.getLevel() + ")");
        System.out.println("==========================================");

        int roundNumber = 1;

        while (player.getCharacter().isAlive() && enemy.isAlive()) {
            // Pergunta escolhida com dificuldade igual ao nível do inimigo
            Question question = questionBank.getByDifficulty(enemy.getLevel());

            Round round = new Round(player, enemy, question, scanner, roundNumber);
            round.execute();

            roundNumber++;
        }

        if (player.getCharacter().isAlive()) {
            System.out.println("\n" + enemy.getName() + " foi derrotado!");
            player.registerEnemyDefeated();
            return true;
        } else {
            System.out.println("\n" + player.getCharacter().getName() + " foi derrotado.");
            return false;
        }
    }
}
