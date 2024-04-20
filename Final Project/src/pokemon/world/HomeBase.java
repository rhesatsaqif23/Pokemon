package pokemon.world;

import java.util.ArrayList;
import java.util.List;
import pokemon.item.Item;
import pokemon.monster.Monster;
import pokemon.monster.Element;

public class HomeBase {
    private List<Monster> ownedMonster;
    private List<Item> ownedItem;

    public HomeBase() {
        ownedMonster = new ArrayList<>();
        ownedItem = new ArrayList<>();
    }

    public List<Monster> getOwnedMonster() {
        return ownedMonster;
    }

    public List<Item> getOwnedItem() {
        return ownedItem;
    }

    public void addMonster(Monster monster) {
        ownedMonster.add(monster);
    }

    public void addItem(Item item) {
        ownedItem.add(item);
    }

    public void levelUp(Monster monster) {
        int minimumEp = 100 + (monster.getLevel() * 5);
        System.out.println("EP before level up: " + monster.getEp() + "/" + minimumEp);

        if (monster.getEp() >= minimumEp) {
            monster.setLevel(monster.getLevel() + 1);
            monster.setEp(monster.getEp() - minimumEp);
            monster.setEvolved(false);
            minimumEp = 100 + (monster.getLevel() * 5);
            System.out.println(monster.getName() + " leveled up to level " + monster.getLevel() + "!");
            System.out.println("EP after level up: " + monster.getEp() + "/" + minimumEp);
        } else {
            System.out.println("Level up failed, not enough EP!");
        }
    }

    public void heal(Monster monster) {
        monster.setHp(monster.getMaxHp());
        System.out.println(monster.getName() + " has been healed!");
    }

    public void evolve(Monster monster, Element newElement) {
        if (!monster.isEvolved()) {
            if (monster.canEvolve(newElement)) {
                monster.setElement(newElement);
                System.out.println(monster.getName() + " evolved into " + newElement + " element!");
            } else {
                System.out.println(monster.getElement() + " can't evolve into " + newElement + " element!");
            }
        } else {
            System.out.println("Evolution can only be done once per level!");
        }
    }
}