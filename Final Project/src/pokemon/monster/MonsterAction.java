package pokemon.monster;

import pokemon.item.Item;

public interface MonsterAction {
    public void basicAttack(Monster enemy);
    public void specialAttack(Monster enemy);
    public void elementalAttack(Monster enemy);
    public void useItem(Item item);
    public boolean escape();
}