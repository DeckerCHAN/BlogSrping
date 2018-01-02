package com.deckerchan.blog.game.entites;

import com.deckerchan.blog.game.api.ShellType;
import com.deckerchan.blog.game.api.turret.TurretInfo;

public abstract class Turret implements TurretInfo {
    protected double traverseSpeed;
    protected ShellType shellType;
    protected double firingRange;
    protected double aimingDegree;
    protected double shellTravelSpeed;
    protected final double loadingInterval;
    protected double loadCountDown;

    public Turret(double traverseSpeed, ShellType shellType, double firingRange, double aimingDegree, double shellTravelSpeed, double loadingInterval) {
        this.traverseSpeed = traverseSpeed;
        this.shellType = shellType;
        this.firingRange = firingRange;
        this.aimingDegree = aimingDegree;
        this.shellTravelSpeed = shellTravelSpeed;
        this.loadingInterval = loadingInterval;
        this.loadCountDown = loadingInterval;
    }

    @Override
    public double getAimingDegree() {
        return this.aimingDegree;
    }

    @Override
    public double getFiringRange() {
        return this.firingRange;
    }


    @Override
    public ShellType getShellType() {
        return this.shellType;
    }

    @Override
    public double getShellTravelSpeed() {
        return this.shellTravelSpeed;
    }


    @Override
    public double getLoadCountDown() {
        return this.loadCountDown;
    }

    @Override
    public double getTraverseSpeed() {
        return this.traverseSpeed;
    }

}
