package pokemon.world;

public class Player {
    private String name;
    private HomeBase homeBase;
    private Dungeon dungeon;

    public Player(String name) {
        this.name = name;
        this.homeBase = new HomeBase();
    }

    public String getName() {
        return name;
    }

    public HomeBase getHomeBase() {
        return homeBase;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void enterDungeon() {
        this.dungeon = new Dungeon();
    }

    public void leaveDungeon() {
        this.dungeon = null;
    }
}