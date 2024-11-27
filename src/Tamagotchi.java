public class Tamagotchi {
    private String petName;
    private int hunger;
    private int happiness;
    private int health;
    private boolean isAlive;

    public Tamagotchi(String name) {
        petName = name;
        hunger = 50;
        happiness = 50;
        health = 100;
        isAlive = true;
    }

    public void feed() {
        if (isAlive && hunger > 0) {
            int foodEffect = (int) (Math.random() * 15 + 5);
            hunger = Math.max(hunger - foodEffect, 0);
            health = Math.min(health + 5, 100);
            System.out.println(petName + " has been fed! Hunger reduced by " + foodEffect + ". Current Hunger: " + hunger + ".");
        } else if (!isAlive) {
            System.out.println(petName + " DIED and can't be fed.");
        } else {
            System.out.println(petName + " is not hungry!");
        }
    }

    public void play() {
        if (isAlive) {
            int funEffect = (int) (Math.random() * 10 + 5);
            happiness = Math.min(happiness + funEffect, 100);
            hunger = Math.min(hunger + 5, 100);
            if (hunger > 80 || health < 50) {
                health = Math.max(health - 10, 0);
            }
            System.out.println(petName + " played and had fun! Happiness increased by " + funEffect + ". Current Happiness: " + happiness + ".");
        } else {
            System.out.println(petName + " DIED and can't play.");
        }
    }

    public void checkStatus() {
        System.out.println("Name: " + petName);
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("Alive: " + (isAlive ? "Yes" : "No"));

        if (health <= 0 || hunger >= 100) {
            isAlive = false;
            System.out.println(petName + " has died due to poor health or extreme hunger...");
        }
    }

    public void randomEvent() {
        if (isAlive) {
            int event = (int) (Math.random() * 3);
            if (event == 0) {
                System.out.println("A rare treat was found! Hunger reduced slightly.");
                hunger = Math.max(hunger - 10, 0);
            } else if (event == 1) {
                System.out.println("A surprise rainstorm made " + petName + " sick. Health decreased.");
                health = Math.max(health - 15, 0);
            } else {
                System.out.println(petName + " found a treasure chest! Happiness increased.");
                happiness = Math.min(happiness + 20, 100);
            }
        } else {
            System.out.println(petName + " is no longer alive and can't experience events.");
        }
    }
}
