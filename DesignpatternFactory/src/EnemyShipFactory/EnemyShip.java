package EnemyShipFactory;

public abstract class EnemyShip {
    private String name;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void shoot(){
        System.out.println("Das Schiff " + getName() + " verursacht " + getDamage() + " Schaden.");
    }
}
