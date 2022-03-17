package ru.ylabs.crosszero.model;

public enum PlayerType {
    USER,

    COMPUTER;

    @Override
    public String toString() {
        return "PlayerType{}" + name();
    }
}
