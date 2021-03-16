package chess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueenTest {
    @DisplayName("Queen 객체 생성 확인")
    @Test
    void 퀸_객체_생성() {
        Queen queen = new Queen(Position.of(0, 0), "Q");

        assertThat(queen.getPosition()).isEqualTo(Position.of(0, 0));
        assertThat(queen.getName()).isEqualTo("Q");
    }

    @DisplayName("초기화된 퀸 객체들 생성 확인")
    @Test
    void 퀸_객체들_생성() {
        List<Queen> queens = Queen.generate();

        assertThat(queens.size()).isEqualTo(2);
    }
}
