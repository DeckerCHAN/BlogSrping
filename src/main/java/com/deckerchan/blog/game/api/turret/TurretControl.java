package com.deckerchan.blog.game.api.turret;

import com.deckerchan.blog.game.api.ShellType;

public interface TurretControl {
    double setAimDegree();

    void fire(double distance);

    void loadShell(ShellType shellType);
}
