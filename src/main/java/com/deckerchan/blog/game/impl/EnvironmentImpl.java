package com.deckerchan.blog.game.impl;

import com.deckerchan.blog.game.api.ship.EnemyInfo;
import com.deckerchan.blog.game.api.ship.ShipControl;
import com.deckerchan.blog.game.api.Environment;
import com.deckerchan.blog.game.api.ship.ShipInfo;

import java.util.Collection;

public class EnvironmentImpl implements Environment {

    @Override
    public long getTimeElapsed() {
        return 0;
    }

    @Override
    public Collection<ShipInfo> getShipsInfo() {
        return null;
    }

    @Override
    public Collection<EnemyInfo> getEnemies() {
        return null;
    }
}
