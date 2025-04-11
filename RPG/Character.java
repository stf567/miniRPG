package RPG;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Character implements Serializable, Saveable {
    private String name;
    private int health;
    private int attackPower;
    private List<ItemType> inventory;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.inventory = new ArrayList<>();
    }

    public abstract void attack(Character target, Random random);

    public void useItem(ItemType item) {
        switch (item) {
            case HEALING_POTION:
                this.health += 50;
                System.out.println(name + " использовал лечебное зелье. Здоровье увеличено на 50.");
                break;
            case MANA_POTION:
                System.out.println(name + " использовал зелье маны. Энергия восстановлена!");
                break;
            default:
                System.out.println("Предмет не имеет эффекта.");
        }
        inventory.remove(item);
    }

    public void addItem(ItemType item) {
        inventory.add(item);
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getAttackPower() { return attackPower; }
    public List<ItemType> getInventory() { return inventory; }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        }
    }

    @Override
    public Character loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Character) in.readObject();
        }
    }
}
