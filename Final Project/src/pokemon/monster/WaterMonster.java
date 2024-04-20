package pokemon.monster;

public class WaterMonster extends Monster {
    private Element strongTo = Element.FIRE;
    private Element weakTo = Element.EARTH;

    public WaterMonster(String name, int level, int hp, int ep) {
        super(name, level, hp, ep, Element.WATER);
    }

    @Override
    public boolean canEvolve(Element newElement) {
        return newElement == Element.WIND || newElement == Element.ICE;
    }

    @Override
    public void basicAttack(Monster enemy) {
        double damage = getLevel() * 9;
        double enemyHealth = enemy.getHp() - damage;
        enemy.setHp(enemyHealth);
        System.out.println(getName() + " attacks " + enemy.getName() + " with basic attack!");
        System.out.println("Damage received: " + damage);
        System.out.println(enemy.getName() + " health: " + enemy.getHp());
    }

    @Override
    public void specialAttack(Monster enemy) {
        double damage = getLevel() * 21;
        double missChance = 0.25;

        if (Math.random() >= missChance) {
            double enemyHealth = enemy.getHp() - damage;
            enemy.setHp(enemyHealth);
            System.out.println(getName() + " attacks " + enemy.getName() + " with special attack!");
            System.out.println("Damage received: " + damage);
            System.out.println(enemy.getName() + " health: " + enemy.getHp());
        } else {
            System.out.println(getName() + " missed special attack!");
        }

        double selfDamage = getHp() * 0.075;
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
            damage = getLevel() * 24;
        } else if (enemy.getElement() == weakTo) {
            System.out.println(getElement() + " is weak against " + enemy.getElement());
            damage = getLevel() * 9;
        } else {
            damage = getLevel() * 12;
        }
        
        double enemyHealth = enemy.getHp() - damage;
        enemy.setHp(enemyHealth);
        System.out.println("Damage received: " + damage);
        System.out.println(enemy.getName() + " health: " + enemy.getHp());
    }
}