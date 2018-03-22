package org.academiadecodigo.haltistas.AwesomeGame.server.apple;

import org.academiadecodigo.haltistas.AwesomeGame.server.ServerPosition;

import java.util.Objects;

public class Apple {

    private ServerPosition position;
    private AppleType type;

    public Apple(ServerPosition position, AppleType type) {

        this.position = position;
        this.type = type;
    }

    public boolean compare(ServerPosition head) {
        return position.equals(head);
    }

    public AppleType getType() {
        return type;
    }

    public ServerPosition getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return type.toString().toLowerCase() + "-" + position.getRow() + "-" + position.getColumn();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(position, apple.position) &&
                type == apple.type;
    }

    @Override  // apagar????
    public int hashCode() {

        return Objects.hash(position, type);
    }

    public boolean hasPosition(ServerPosition position) {
        return this.position.equals(position);
    }
}
