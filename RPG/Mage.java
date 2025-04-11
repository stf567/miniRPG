package RPG;

import java.util.Random;

public class Mage extends Character {
    private int mana;

    public Mage(String name) {
        super(name, 100, 40);
        this.mana = 100;
    }

    @Override
    public void attack(Character target, Random random) {
        if (mana >= 20) {
            int damage = this.getAttackPower() + random.nextInt(15);
            target.setHealth(target.getHealth() - damage);
            mana -= 20;
            System.out.println(getName() + " бросает огненный шар и наносит " + damage + " урона!");
        } else {
            int damage = 10 + random.nextInt(5);
            target.setHealth(target.getHealth() - damage);
            System.out.println(getName() + " бьет посохом и наносит " + damage + " урона!");
        }
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
}
