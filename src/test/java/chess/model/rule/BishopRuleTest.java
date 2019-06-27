package chess.model.rule;

import chess.model.Side;
import chess.model.board.Board;
import chess.model.board.Column;
import chess.model.board.Row;
import chess.model.board.Square;
import chess.model.unit.Bishop;
import chess.model.unit.Pawn;
import chess.model.unit.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BishopRuleTest {
    private Board board;
    private Square checkTarget;
    private Square destination;
    private Piece piece;
    private boolean result;

    @BeforeEach
    void setUp() {
        board = Board.makeEmptyBoard();
    }

    @Test
    void 대각선으로_자유자재_이동() {
        checkTarget = new Square(Column.D, Row._5);
        piece = new Bishop(Side.WHITE);
        board.setPiece(checkTarget, piece);

        destination = new Square(Column.C, Row._6);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.E, Row._6);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.C, Row._4);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.E, Row._4);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.A, Row._8);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.G, Row._8);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.A, Row._2);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.G, Row._2);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();
    }

    @Test
    void 좌측_상단_끄트머리() {
        checkTarget = new Square(Column.A, Row._8);
        piece = new Bishop(Side.BLACK);
        board.setPiece(checkTarget, piece);

        destination = new Square(Column.B, Row._7);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.H, Row._1);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.D, Row._5);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();
    }

    @Test
    void 우측_하단_끄트머리() {
        checkTarget = new Square(Column.H, Row._1);
        piece = new Bishop(Side.WHITE);
        board.setPiece(checkTarget, piece);

        destination = new Square(Column.G, Row._2);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.A, Row._8);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.D, Row._5);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();
    }

    @Test
    void 이동불가능한_곳() {
        checkTarget = new Square(Column.D, Row._5);
        piece = new Bishop(Side.BLACK);
        board.setPiece(checkTarget, piece);

        destination = new Square(Column.B, Row._6);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.H, Row._7);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.D, Row._6);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();
    }

    @Test
    void 이동불가능한_곳_좌상단끄트머리() {
        checkTarget = new Square(Column.A, Row._8);
        piece = new Bishop(Side.WHITE);
        board.setPiece(checkTarget, piece);

        destination = new Square(Column.B, Row._6);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.H, Row._5);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.B, Row._8);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();
    }

    @Test
    void 이동불가능한_곳_우하단끄트머리() {
        checkTarget = new Square(Column.H, Row._1);
        piece = new Bishop(Side.WHITE);
        board.setPiece(checkTarget, piece);

        destination = new Square(Column.H, Row._1);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.F, Row._2);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.G, Row._3);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.B, Row._8);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();
    }

    @Test
    void 같은편에_길막당했을때() {
        checkTarget = new Square(Column.D, Row._5);
        piece = new Bishop(Side.BLACK);
        board.setPiece(checkTarget, piece);
        piece = new Pawn(Side.BLACK);
        board.setPiece(new Square(Column.E, Row._4), piece);

        destination = new Square(Column.E, Row._4);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.F, Row._3);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.H, Row._1);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isFalse();

        destination = new Square(Column.C, Row._6);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();

        destination = new Square(Column.A, Row._8);
        result = Rule.isValidMove(board, checkTarget, destination);
        assertThat(result).isTrue();
    }
}