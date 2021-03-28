package chess.domain.piece;

import chess.domain.piece.info.Color;
import chess.domain.piece.info.Name;
import chess.domain.piece.info.Score;
import chess.domain.position.Direction;
import chess.domain.position.Position;

public abstract class Piece {
    protected Position position;
    protected Name name;
    protected Color color;
    protected Score score;

    public Piece(Position position, Name name, Color color) {
        this(position, name, color, Score.ZERO);
    }

    public Piece(Position position, Name name, Color color, Score score) {
        this.position = position;
        this.name = name;
        this.color = color;
        this.score = score;
    }

    public void move(Position target) {
        this.position = target;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.nameByColor(color);
    }

    public double score() {
        return score.getValue();
    }

    public boolean isSameTeam(Piece targetPiece) {
        return this.color.same(targetPiece.color);
    }

    public boolean isSameTeam(Color anotherColor) {
        return this.color.same(anotherColor);
    }

    public boolean isEmpty() {
        return this instanceof Empty;
    }

    public boolean isPawn() {
        return this instanceof Pawn;
    }

    public boolean isKnight() {
        return this instanceof Knight;
    }

    public boolean isKing() {
        return this instanceof King;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public abstract void checkMovable(Piece targetPiece, Direction direction);
}
