package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";

    public int inputPrice() {
        return SCANNER.nextInt();
    }

    public void inputNextLine() {
        SCANNER.nextLine();
    }

    public String[] inputWinningNumbers() {
        String[] strings = SCANNER.nextLine().split(SPLIT_REGEX);
        int count = (int) Arrays.stream(strings)
                .distinct()
                .count();
        if (count != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복이 없어야 하며, 6개여야 합니다.");
        }
        return strings;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : inputWinningNumbers()) {
            winningNumbers.add(Integer.parseInt(numberString));
        }
        return winningNumbers;
    }

    public int getBonusBallNumber() {
        return SCANNER.nextInt();
    }

}
