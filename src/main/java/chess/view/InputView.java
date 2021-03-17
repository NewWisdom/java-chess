package chess.view;

import java.util.Scanner;

public class InputView {
    private static final String START = "start";
    private static final String END = "end";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static boolean inputIfWantToStart() {
        String input = SCANNER.nextLine();
        if (START.equals(input)) {
            return true;
        }
        if (END.equals(input)) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] start 또는 end만 입력 가능합니다.");
    }
}
