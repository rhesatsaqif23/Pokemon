package pokemon.monster;

public class FireMonster extends Monster {
    private Element strongTo = Element.ICE;
    private Element weakTo = Element.WATER;

    public FireMonster(String name, int level, int hp, int ep) {
        super(name, level, hp, ep, Element.FIRE);
    }

    @Override
    public boolean canEvolve(Element newElement) {
        return newElement == Element.EARTH || newElement == Element.WIND;
    }

    @Override
    public void basicAttack(Monster enemy) {
        double damage = getLevel() * 10;
        double enemyHealth = enemy.getHp() - damage;
        enemy.setHp(enemyHealth);
        System.out.println(getName() + " attacks " + enemy.getName() + " with basic attack!");
        System.out.println("Damage received: " + damage);
        System.out.println(enemy.getName() + " health: " + enemy.getHp());
    }

    @Override
    public void specialAttack(Monster enemy) {
        double damage = getLevel() * 20;
        double missChance = 0.1;

        if (Math.random() >= missChance) {
            double enemyHealth = enemy.getHp() - damage;
            enemy.setHp(enemyHealth);
            System.out.println(getName() + " attacks " + enemy.getName() + " with special attack!");
            System.out.println("Damage received: " + damage);
            System.out.println(enemy.getName() + " health: " + enemy.getHp());
        } else {
            System.out.println(getName() + " missed special attack!");
        }

        double selfDamage = getHp() * 0.15;
        setHp(getHp() - selfDamage);
        System.out.println("Self damage: " + selfDamage);
        System.out.println(getName() + " health: " + getHp());
    }

    @Override
    public void elementalAttack(Monster enemy) {
        double damage;
        System.out.println(getName() + " attacks " + enemy.getName() + " with elemental attack!");

        if (enemy.getElement() == strongTo) {
            System.out.println(getElement() + " is strong against " + enemy.getElement());
            damage = getLevel() * 25;
        } else if (enemy.getElement() == weakTo) {
            System.out.println(getElement() + " is weak against " + enemy.getElement());
            damage = getLevel() * 5;
        } else {
            damage = getLevel() * 15;
        }

        double enemyHealth = enemy.getHp() - damage;
        enemy.setHp(enemyHealth);
        System.out.println("Damage received: " + damage);
        System.out.println(enemy.getName() + " health: " + enemy.getHp());
    }
}