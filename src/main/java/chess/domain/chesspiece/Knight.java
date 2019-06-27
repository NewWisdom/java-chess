package chess.domain.chesspiece;

import chess.domain.chesspoint.ChessPoint;
import chess.domain.chesspoint.RelativeChessPoint;
import chess.domain.util.Counter;

import java.util.List;

public class Knight implements BasicChessPiece {
    public static final double SCORE = 2.5;
    private static final List<ChessDirection> UNIT_DIRECTIONS = ChessDirection.knightDirection();
    private static final String NAME = "N";
    private static Knight knight = null;

    private Knight() {
    }

    public static Knight getInstance() {
        if (knight == null) {
            knight = new Knight();
        }
        return knight;
    }

    @Override
    public boolean checkRule(ChessPoint source, ChessPoint target) {
        RelativeChessPoint direction = target.minus(source);
        return UNIT_DIRECTIONS.stream().anyMatch(d -> d.match(direction));
    }

    @Override
    public Counter<Integer> countPiecesOnSameColumn(Counter<Integer> pawnCounter, int column) {
        return pawnCounter;
    }

    @Override
    public double getScore(Counter<Integer> pawnCounter, int column) {
        return SCORE;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean hasName(String name) {
        return NAME.equals(name);
    }

    @Override
    public boolean isPawn() {
        return false;
    }
}