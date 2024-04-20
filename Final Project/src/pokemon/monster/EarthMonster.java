package pokemon.monster;

public class EarthMonster extends Monster {
    private Element strongTo = Element.WATER;
    private Element weakTo = Element.WIND;

    public EarthMonster(String name, int level, int hp, int ep) {
        super(name, level, hp, ep, Element.EARTH);
    }

    @Override
    public boolean canEvolve(Element newElement) {
        return newElement == Element.ICE || newElement == Element.FIRE;
    }

    @Override
    public void basicAttack(Monster enemy) {
        double damage = getLevel() * 11;
        double enemyHealth = enemy.getHp() - damage;
        enemy.setHp(enemyHealth);
        System.out.println(getName() + " attacks " + enemy.getName() + " with basic attack!");
        System.out.println("Damage received: " + damage);
        System.out.println(enemy.getName() + " health: " + enemy.getHp());
    }

    @Override
    public void specialAttack(Monster enemy) {
        double damage = getLevel() * 19;
        double missChance = 0.15;
        
        if (Math.random() >= missChance) {
            double enemyHealth = enemy.getHp() - damage;
            enemy.setHp(enemyHealth);
            System.out.println(getName() + " attacks " + enemy.getName() + " with special attack!");
            System.out.println("Damage received: " + damage);
            System.out.println(enemy.getName() + " health: " + enemy.getHp());
        } else {
            System.out.println(getName() + " missed special attack!");
        }

        double selfDamage = getHp() * 0.125;
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
            damage = getLevel() * 23;
        } else if (enemy.getElement() == weakTo) {
            System.out.println(getElement() + " is weak against " + enemy.getElement());
            damage = getLevel() * 8;
        } else {
            damage = getLevel() * 14;
        }
        
        double enemyHealth = enemy.getHp() - damage;
        enemy.setHp(enemyHealth);
        System.out.println("Damage received: " + damage);
        System.out.println(enemy.getName() + " health: " + enemy.getHp());
    }
}