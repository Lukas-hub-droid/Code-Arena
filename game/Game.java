package game;

import battle.BattleManager;
import model.Character;
import model.Enemy;
import model.Player;
import model.Sage;
import model.Warrior;
import question.QuestionBank;
import score.ScoreSystem;

import java.util.Scanner;


public class Game {

    private Player       player;
    private QuestionBank questionBank;
    private Scanner      scanner;
    private ScoreSystem  scoreSystem;

    public Game() {
        questionBank = new QuestionBank();
        scanner      = new Scanner(System.in);
        scoreSystem  = new ScoreSystem();
    }

    public void start() {
        printWelcome();
        setupPlayer();

        boolean playerWon = runAllBattles();

        scoreSystem.showFinalStats(player, playerWon);
        scanner.close();
    }



    private void printWelcome() {
        System.out.println("==========================================");
        System.out.println("  CodeArena: Batalha do Conhecimento");
        System.out.println("==========================================");
        System.out.println("Perguntas carregadas: " + questionBank.size());
        System.out.println();
    }

    private void setupPlayer() {
        System.out.print("Digite seu nome: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Jogador";

        System.out.println();
        System.out.println("Escolha seu personagem:");
        System.out.println("1) Sabio     - Vida: 140 | Ataque: 15 | Defesa: 10");
        System.out.println("   Habilidades: Dica (elimina alternativa) + Escudo (bloqueia dano)");
        System.out.println();
        System.out.println("2) Guerreiro - Vida: 120 | Ataque: 25 | Defesa: 5");
        System.out.println("   Habilidades: Dano Duplo (dobra dano) + Cura (recupera vida)");
        System.out.println();
        System.out.print("Escolha (1 ou 2): ");

        String choice = scanner.nextLine().trim();
        Character character = choice.equals("2") ? new Warrior(name) : new Sage(name);

        player = new Player(name, character);

        System.out.println("\nPersonagem selecionado: " + player.getCharacter());
        System.out.println();
    }


    private boolean runAllBattles() {
        Enemy[] enemies = {
            new Enemy("Aprendiz do Bug",    60,  8,  2, 1),
            new Enemy("Guardiao da Logica", 90,  12, 4, 2),
            new Enemy("Mestre do Codigo",   120, 18, 6, 3)
        };

        for (int i = 0; i < enemies.length; i++) {
            System.out.println("\nBatalha " + (i + 1) + " de " + enemies.length +
                               " — " + enemies[i].getName());

            // Recuperação entre batalhas (exceto antes da primeira)
            if (i > 0) {
                int heal = player.getCharacter().getMaxLife() / 5;
                player.getCharacter().heal(heal);
                System.out.println("Recuperacao entre batalhas: +" + heal + " de vida.");
            }

            BattleManager battle = new BattleManager(player, enemies[i], questionBank, scanner);
            boolean won = battle.run();

            if (!won) {
                return false;
            }

            System.out.println("Pontuacao atual: " + player.getScore());
        }

        return true;
    }
}
