package chess.domain.piece;

import chess.domain.Color;
import chess.domain.Name;
import chess.domain.position.Position;

public class Empty extends Piece {
    public Empty() {
        this(Position.EMPTY, Name.NONE, Color.NONE);
    }

    public Empty(Position position, Name name, Color color) {
        super(position, name, color);
    }

    @Override
    public void move(Position target, Pieces pieces) {
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 기물입니다.");
    }

    @Override
    public void checkMoveRule(Position target) {
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 기물입니다.");
    }
}
