package pw.hysteria.classes.framework;

public class Profile {

    private Class clazz;
    private Level level;

    public Profile(Class clazz, Level level){
        this.clazz = clazz;
        this.level = level;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Level getLevel() {
        return level;
    }
}
