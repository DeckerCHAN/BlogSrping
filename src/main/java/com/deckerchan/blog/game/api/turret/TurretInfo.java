package com.deckerchan.blog.game.api.turret;

import com.deckerchan.blog.game.api.ShellType;

public interface TurretInfo {
    double getAimingDegree();

    double getFiringRange();

    ShellType getShellType();

    double getShellTravelSpeed();

    double getTraverseSpeed();

    double getLoadCountDown();
}
