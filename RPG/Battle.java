package RPG;

import java.util.Random;

public class Battle {
    public static void startBattle(Character player1, Character player2) {
        Random random = new Random();
        System.out.println("Бой начинается между " + player1.getName() + " и " + player2.getName() + "!");

        while (player1.isAlive() && player2.isAlive()) {
            // Ход первого игрока
            if (player1.isAlive()) {
                performTurn(player1, player2, random);
            }

            // Ход второго игрока
            if (player2.isAlive()) {
                performTurn(player2, player1, random);
            }

            // Вывод состояния
            System.out.println("\nСостояние боя:");
            System.out.println(player1.getName() + " Здоровье: " + player1.getHealth());
            System.out.println(player2.getName() + " Здоровье: " + player2.getHealth() + "\n");
        }
    }

    private static void performTurn(Character attacker, Character defender, Random random) {
        attacker.attack(defender, random);
        if (!defender.isAlive()) return;

        // Шанс использовать предмет (30%)
        if (random.nextDouble() < 0.3 && !attacker.getInventory().isEmpty()) {
            ItemType item = attacker.getInventory().get(0);
            attacker.useItem(item);
        }
    }
}
