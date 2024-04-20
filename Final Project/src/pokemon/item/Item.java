package pokemon.item;

import pokemon.monster.Monster;

public class Item {
    private String name;
    private ItemType type;

    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public void use(Monster monster) {
        switch (type) {
            case HEALTH_POTION:
                double heal = monster.getHp() * 0.2;
                monster.setHp(monster.getHp() + heal);
                System.out.println(monster.getName() + " used " + getName() + " and recovered " + heal + " HP" );
                System.out.println(monster.getName() + " health: " + monster.getHp());
                break;
            default:
                break;
        }
    }
}