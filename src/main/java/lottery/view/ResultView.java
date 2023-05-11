package lottery.view;

import java.util.List;
import lottery.domain.Lottery;
import lottery.domain.constant.Rank;

public class ResultView {

    private static final String STATISTICS_RESULT_BANNER = "당첨 통계";

    private static final String SEPARATOR_LINE = "----------";

    private static final String STATISTICS_FORMAT = "%d개 일치 (%d원) -%d개";

    private static final String BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) -%d개";

    private static final String RETURN_ON_INVESTMENT_FORMAT = "총 수익률은 %.2f 입니다.";

    public static void printLotteries(List<Lottery> lotteries) {
        lotteries.forEach(lottery -> printSource(lottery.toString()));
    }

    public static void printStatisticsResultBanner() {
        printSource(STATISTICS_RESULT_BANNER);
        printSource(SEPARATOR_LINE);
    }

    public static void printStatisticsResult(Rank rank, int numberOfWins) {
        if(Rank.isSecond(rank)) {
            printSource(String.format(BONUS_FORMAT,
                    rank.getCountOfMatch(),
                    rank.getWinningMoney(),
                    numberOfWins));
            return;
        }
        printSource(String.format(STATISTICS_FORMAT,
                rank.getCountOfMatch(),
                rank.getWinningMoney(),
                numberOfWins));
    }

    public static void printReturnRate(double returnRate) {
        printSource(String.format(RETURN_ON_INVESTMENT_FORMAT,roundTwoDecimals(returnRate)));
    }

    private static double roundTwoDecimals(double returnRate) {
        return (double) Math.round(returnRate * 100) / 100;
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
