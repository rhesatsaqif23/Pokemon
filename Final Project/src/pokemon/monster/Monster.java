package pokemon.monster;

import pokemon.item.Item;

public abstract class Monster implements MonsterAction {
    private String name;
    private int level;
    private double hp;
    private double maxHp;
    private int ep;
    private Element element;
    private boolean evolved;

    public Monster(String name, int level, double hp, int ep, Element element) {
        this.name = name;
        this.level = level;
        this.hp = this.maxHp = hp;
        this.ep = ep;
        this.element = element;
        this.evolved = false;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public int getEp() {
        return ep;
    }

    public Element getElement() {
        return element;
    }

    public boolean isEvolved() {
        return evolved;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(double hp) {
        this.hp = hp;
        if (!isAlive()) {
            this.hp = 0;
        }
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void setEvolved(boolean evolved) {
        this.evolved = evolved;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    public abstract boolean canEvolve(Element newElement);

    @Override
    public abstract void basicAttack(Monster enemy);

    @Override
    public abstract void specialAttack(Monster enemy);

    @Override
    public abstract void elementalAttack(Monster enemy);

    @Override
    public void useItem(Item item) {
        item.use(this);
    }

    @Override
    public boolean escape() {
        double chance = Math.random();
        if (chance > 0.5) {
            System.out.println(getName() + " escapes succesfully!");
            return true;
        } else {
            System.out.println(getName() + " failed to escape!");
            return false;
        }
    }
}