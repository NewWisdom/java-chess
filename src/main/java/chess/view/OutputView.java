package chess.view;

import chess.domain.piece.CurrentPieces;
import chess.domain.piece.Empty;
import chess.domain.piece.Piece;
import chess.domain.piece.Position;

import static chess.domain.piece.Position.POSITIONS;

public class OutputView {
    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요");
    }

    public static void printChessBoard(CurrentPieces currentPieces) {
        for (int i = 0; i < POSITIONS.size(); i++) {
            if (i % 8 == 0) {
                System.out.println();
            }
            Piece piece = findByPosition(POSITIONS.get(i), currentPieces);
            System.out.print(piece.getName());
        }
        System.out.println();
    }

    private static Piece findByPosition(Position position, CurrentPieces currentPieces) {
        return currentPieces.getCurrentPieces()
                .stream()
                .filter(piece -> position.equals(piece.getPosition()))
                .findFirst()
                .orElse(Empty.EMPTY);
    }
}
