package pw.hysteria.classes.framework;

public class Level {

    private final int level;
    private final int xp;

    public Level(int level, int xp){
        this.level = level;
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }
}
