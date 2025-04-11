package RPG;

import java.util.Random;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 150, 25);
    }

    @Override
    public void attack(Character target, Random random) {
        int damage = this.getAttackPower() + random.nextInt(10);
        target.setHealth(target.getHealth() - damage);
        System.out.println(getName() + " наносит удар мечом и наносит " + damage + " урона!");
    }
}
