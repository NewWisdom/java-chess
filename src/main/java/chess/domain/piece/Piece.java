package chess.domain.piece;

import chess.domain.Color;
import chess.domain.Name;

public abstract class Piece {
    protected Position position;
    protected Name name;
    protected Color color;
    protected Score score;

    public Piece(Position position, Name name, Color color) {
        this(position, name, color, new Score(0));
    }

    public Piece(Position position, Name name, Color color, Score score) {
        this.position = position;
        this.name = name;
        this.color = color;
        this.score = score;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.nameByColor(color);
    }

    public abstract void move(Position target, CurrentPieces currentPieces);

    public Color getColor() {
        return color;
    }

    public Score getScore() {
        return score;
    }
}
