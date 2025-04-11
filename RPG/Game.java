package RPG;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Геркулес");
        Mage mage = new Mage("Мерлин");

        // Добавляем предметы
        warrior.addItem(ItemType.HEALING_POTION);
        mage.addItem(ItemType.MANA_POTION);

        // Сохранение и загрузка
        try {
            warrior.saveToFile("warrior.sav");
            Character loaded = warrior.loadFromFile("warrior.sav");
            System.out.println("Загружен персонаж: " + loaded.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Начало боя
        Battle.startBattle(warrior, mage);
    }
}
