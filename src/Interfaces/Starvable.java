package Interfaces;

import static app_main.Settings.STARVE_DAMAGE;

public interface Starvable {
    int damage = STARVE_DAMAGE;
    default void starve() {
        this.takeDamage(damage);
    }

    void takeDamage(int damage);
}
