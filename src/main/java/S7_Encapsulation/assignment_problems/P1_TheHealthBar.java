class Character {
    private int health;
    private final int maxHealth;

    // Constructor
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // Take damage
    public void takeDamage(int amount) {
        health = health - amount;

        if (health < 0) {
            health = 0;
        }
    }

    // Heal character
    public void heal(int amount) {
        health = health + amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    // Read-only access to health
    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

public class P1_TheHealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);

        System.out.println("Initial Health: " + c.getHealth());

        c.takeDamage(30);
        System.out.println("After 30 Damage: " + c.getHealth());

        c.heal(50);
        System.out.println("After 50 Healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("After 150 Damage: " + c.getHealth());
    }
}