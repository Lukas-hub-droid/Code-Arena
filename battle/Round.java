package battle;

import ability.SpecialAbility;
import exception.InvalidChoiceException;
import model.Enemy;
import model.Player;
import question.Question;

import java.util.Scanner;



public class Round {

    private Player   player;
    private Enemy    enemy;
    private Question question;
    private Scanner  scanner;
    private int      number;

    public Round(Player player, Enemy enemy, Question question, Scanner scanner, int number) {
        this.player   = player;
        this.enemy    = enemy;
        this.question = question;
        this.scanner  = scanner;
        this.number   = number;
    }

    public void execute() {
        System.out.println("\n--- Rodada " + number + " ---");
        showStatus();
        offerAbilities();

        System.out.println();
        question.display();

        System.out.print("\nSua resposta: ");
        String answer = scanner.nextLine().trim();

        boolean correct = question.isCorrect(answer);

        if (correct) {
            System.out.println("Correto!");
        } else {
            System.out.println("Incorreto. " + question.getCorrectAnswerText());
        }

        applyEffects(correct);
    }



    private void showStatus() {
        System.out.println(player.getCharacter().getName() +
                           " - Vida: " + player.getCharacter().getLife() +
                           "/" + player.getCharacter().getMaxLife());
        System.out.println(enemy.getName() +
                           " - Vida: " + enemy.getLife() +
                           "/" + enemy.getMaxLife());
    }


    private void offerAbilities() {
        SpecialAbility[] abilities = player.getCharacter().getAbilities();
        int count = player.getCharacter().getAbilityCount();


        int available = 0;
        for (int i = 0; i < count; i++) {
            if (abilities[i].isAvailable()) available++;
        }
        if (available == 0) return;

        System.out.println("\nHabilidades disponiveis:");
        int option = 1;
        for (int i = 0; i < count; i++) {
            if (abilities[i].isAvailable()) {
                System.out.println("  " + option + ") " + abilities[i].getName() +
                                   " - " + abilities[i].getDescription());
                option++;
            }
        }
        System.out.println("  0) Nao usar");


        int choice = -1;
        while (choice == -1) {
            System.out.print("Escolha: ");
            String input = scanner.nextLine().trim();

            try {
                choice = parseChoice(input, available);
            } catch (InvalidChoiceException e) {
                System.out.println("Opcao invalida: " + e.getMessage());

            }
        }

        if (choice == 0) return; // jogador optou por nao usar habilidade

        activateAbility(choice, abilities, count);
    }


    private int parseChoice(String input, int available) throws InvalidChoiceException {
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidChoiceException("digite apenas numeros.");
        }

        if (choice < 0 || choice > available) {
            throw new InvalidChoiceException(
                "digite um numero entre 0 e " + available + ".");
        }

        return choice;
    }


    private void activateAbility(int choice, SpecialAbility[] abilities, int count) {
        int counter = 1;
        for (int i = 0; i < count; i++) {
            if (abilities[i].isAvailable()) {
                if (counter == choice) {
                    abilities[i].use(player.getCharacter(), question);
                    break;
                }
                counter++;
            }
        }
    }


    private void applyEffects(boolean correct) {
        int multiplier = question.getDifficulty();

        if (correct) {
            int rawDamage = player.getCharacter().getAttack() * multiplier;

            if (player.getCharacter().isDoubleDamageActive()) {
                rawDamage *= 2;
                player.getCharacter().setDoubleDamageActive(false);
                System.out.println("Dano Duplo ativo!");
            }



            int actualDamage = enemy.takeDamage(rawDamage);
            player.addScore(question.getPoints());
            player.registerCorrect();
            System.out.println(player.getCharacter().getName() + " causou " +
                               actualDamage + " de dano a " + enemy.getName() + ".");

        } else {
            if (player.getCharacter().isShieldActive()) {
                player.getCharacter().setShieldActive(false);
                System.out.println("O Escudo bloqueou o ataque de " + enemy.getName() + "!");
            } else {
                int rawDamage    = enemy.getAttack() * multiplier;
                int actualDamage = player.getCharacter().takeDamage(rawDamage);
                player.registerWrong();
                System.out.println(enemy.getName() + " causou " +
                                   actualDamage + " de dano a " + player.getCharacter().getName() + ".");
            }
        }
    }
}
