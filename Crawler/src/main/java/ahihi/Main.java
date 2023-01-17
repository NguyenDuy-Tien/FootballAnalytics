package ahihi;

import ahihi.crawler.WhoScoreCrawler;
import ahihi.csv.CsvWriter;
import ahihi.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String directoryPath = new File("").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", directoryPath + "\\src\\main\\resources\\chromedriver.exe");

        System.out.println(directoryPath + "\\src\\main\\resources\\chromedriver.exe");
        List<PlayerSummaryInfo> summaryInfoList = WhoScoreCrawler.crawPlayerSummary();
        CsvWriter.write("WhoScoreSummaryPlayerInfo.csv", summaryInfoList);
        List<PlayerDefensiveInfo> defensiveInfoList = WhoScoreCrawler.crawPlayerDefensive();
        CsvWriter.write("WhoScoreDefensivePlayerInfo.csv", defensiveInfoList);
        List<PlayerOffensiveInfo> offensiveInfoList = WhoScoreCrawler.crawPlayerOffensive();
        CsvWriter.write("WhoScoreOffensivePlayerInfo.csv", offensiveInfoList);
        List<PlayerPassingInfo> passingInfoList = WhoScoreCrawler.crawPlayerPassing();
        CsvWriter.write("WhoScorePassingPlayerInfo.csv", passingInfoList);
        List<PlayerDetailedInfo> detailedInfoList = WhoScoreCrawler.crawPlayerDetail();
        CsvWriter.write("WhoScoreDetailPlayerInfo.csv", detailedInfoList);
    }
}
