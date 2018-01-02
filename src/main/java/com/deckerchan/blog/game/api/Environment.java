package com.deckerchan.blog.game.api;

import com.deckerchan.blog.game.api.ship.EnemyInfo;
import com.deckerchan.blog.game.api.ship.ShipInfo;

import java.util.Collection;

public interface Environment {
    public long getTimeElapsed();
    public Collection<ShipInfo> getShipsInfo();
    public Collection<EnemyInfo> getEnemies();


}
