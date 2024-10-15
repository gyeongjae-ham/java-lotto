package lotto.domain;

import java.util.List;

public enum Rank {
    NORANK("", 0, 0),
    THREE("3개 일치 (5000원)- ", 5_000, 3),
    FOUR("4개 일치 (50000원)- ", 50_000, 4),
    FIVE("5개 일치 (1500000원)- ", 1_500_000, 5),
    SECOND("5개 일치, 보너스 볼 일치(30000000원) - ", 30_000_000, 5),
    WIN("6개 일치 (2000000000원)- ", 2_000_000_000, 6),
    ;

    private final String message;
    private final int prize;
    private final int matchNumber;

    Rank(String message, int prize, int matchNumber) {
        this.message = message;
        this.prize = prize;
        this.matchNumber = matchNumber;
    }

    public static long calculatePrize(List<Lotto> lottos, WinNumber winNumber) {
        long totalPrize = 0;

        for (Lotto lotto : lottos) {
            Rank matched = lotto.match(winNumber);
            totalPrize += matched.prize;
        }

        return totalPrize;
    }

    public static double ratio(long totalPrize, int money) {
        double ratio = (double)totalPrize / money;

        return Math.floor(ratio * 100) / 100.0;
    }

    public static Rank match(int matchCount, boolean isMatchBonus) {
        if (matchCount == THREE.matchNumber) {
            return THREE;
        }

        if (matchCount == FOUR.matchNumber && isMatchBonus) {
            return SECOND;
        }

        if (matchCount == FOUR.matchNumber) {
            return FOUR;
        }

        if (matchCount == FIVE.matchNumber) {
            return FIVE;
        }

        if (matchCount == WIN.matchNumber) {
            return WIN;
        }

        return NORANK;
    }

    public boolean isMatch(Rank compareRank) {
        if (compareRank.matchNumber == this.matchNumber) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        return message;
    }
}
