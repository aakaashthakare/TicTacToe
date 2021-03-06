package com.akash.game;

public interface Player {
    public String getName();

    public Move getMove(PlayerVisibleState state);

    public void setName(String name);
}
