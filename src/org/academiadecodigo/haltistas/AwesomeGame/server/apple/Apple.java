package org.academiadecodigo.haltistas.AwesomeGame.server.apple;

import org.academiadecodigo.haltistas.AwesomeGame.server.ServerPosition;

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
}
