package chess.domain;

import chess.domain.piece.CurrentPieces;
import chess.domain.piece.Piece;
import chess.domain.piece.Position;

import java.util.List;

public class ChessGame {
    private Color turn;
    private final CurrentPieces currentPieces;

    public ChessGame() {
        this.currentPieces = CurrentPieces.generate();
        turn = Color.WHITE;
    }

    public void next() {
        this.turn = turn.reverse();
    }

    public CurrentPieces getCurrentPieces() {
        return currentPieces;
    }

    public void play(Command command) {
        List<String> sourceTarget = command.getSourceTarget();
        Position source = Position.of(sourceTarget.get(0).charAt(0), sourceTarget.get(0).charAt(1));
        Position target = Position.of(sourceTarget.get(1).charAt(0), sourceTarget.get(1).charAt(1));
        Piece sourcePiece = currentPieces.findByPosition(source);
        if (!sourcePiece.getColor().isSame(turn)) {
            throw new IllegalArgumentException("[ERROR] 현재 턴이 아닌 말은 움직일 수 없습니다.");
        }
        sourcePiece.move(target, currentPieces);
        next();
    }

    public boolean isRunning() {
        return currentPieces.isAliveAllKings();
    }
}
