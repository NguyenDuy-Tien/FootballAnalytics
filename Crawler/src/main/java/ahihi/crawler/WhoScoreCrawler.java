package ahihi.crawler;

import ahihi.model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WhoScoreCrawler {
    public static List<PlayerSummaryInfo> crawPlayerSummary() {
        List<PlayerSummaryInfo> result = new ArrayList<>();
        //access and wait for web to load
        WebDriver driver = new ChromeDriver();
        driver.get("https://1xbet.whoscored.com/Statistics");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody[id='player-table-statistics-body']")));


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[href='#top-player-stats-summary']")));
        waitTableLoad(driver);

        while (true) {
            WebElement statisticTable = driver.findElement(By.cssSelector("div[id='statistics-table-summary']")).findElement(By.cssSelector("tbody[id='player-table-statistics-body']"));

            List<WebElement> elements = statisticTable.findElements(By.cssSelector("tr"));

            for (WebElement element : elements) {
                try {
                    String name = element.findElement(By.cssSelector("span[class='iconize iconize-icon-left']")).getText();
                    String team = element.findElement(By.cssSelector("span[class='team-name']")).getText();
                    List<WebElement> metaData = element.findElements(By.cssSelector("span[class='player-meta-data']"));
                    String age = metaData.get(0).getText();
                    String position = metaData.get(1).getText();
                    String apps = element.findElements(By.cssSelector("td")).get(2).getText();
                    int minutePlayed, goal, assistTotal, yellowCard, redCard;
                    float shotsPerGame, passRate, aerialWonPerGame, manOfMatch, rating;
                    try {
                        minutePlayed = Integer.parseInt(element.findElement(By.cssSelector("td[class='minsPlayed   ']")).getText());
                    } catch (NumberFormatException e) {
                        minutePlayed = 0;
                    }
                    try {
                        goal = Integer.parseInt(element.findElement(By.cssSelector("td[class='goal   ']")).getText());
                    } catch (NumberFormatException e) {
                        goal = 0;
                    }
                    try {
                        assistTotal = Integer.parseInt(element.findElement(By.cssSelector("td[class='assistTotal   ']")).getText());
                    } catch (NumberFormatException e) {
                        assistTotal = 0;
                    }
                    try {
                        yellowCard = Integer.parseInt(element.findElement(By.cssSelector("td[class='yellowCard   ']")).getText());
                    } catch (NumberFormatException e) {
                        yellowCard = 0;
                    }
                    try {
                        redCard = Integer.parseInt(element.findElement(By.cssSelector("td[class='redCard   ']")).getText());
                    } catch (NumberFormatException e) {
                        redCard = 0;
                    }

                    try {
                        shotsPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='shotsPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        shotsPerGame = 0;
                    }
                    try {
                        passRate = Float.parseFloat(element.findElement(By.cssSelector("td[class='passSuccess   ']")).getText());
                    } catch (NumberFormatException e) {
                        passRate = 0;
                    }
                    try {
                        aerialWonPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='aerialWonPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        aerialWonPerGame = 0;
                    }
                    try {
                        manOfMatch = Float.parseFloat(element.findElement(By.cssSelector("td[class='manOfTheMatch   ']")).getText());
                    } catch (NumberFormatException e) {
                        manOfMatch = 0;
                    }
                    try {
                        rating = Float.parseFloat(element.findElement(By.cssSelector("td[class='rating   sorted  ']")).getText());
                    } catch (NumberFormatException e) {
                        rating = 0;
                    }
                    System.out.println(name);
                    result.add(new PlayerSummaryInfo(name, team,age,position, apps, minutePlayed, goal, assistTotal, yellowCard, redCard, shotsPerGame, passRate, aerialWonPerGame, manOfMatch, rating));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            WebElement nextButton = driver.findElement(By.cssSelector("div[id='statistics-paging-summary']")).findElement(By.id("next"));
            if (nextButton.getAttribute("class").contains("disabled")) {
                System.out.println(nextButton.getAttribute("class"));
                break;
            } else {
                nextButton.click();
                waitTableLoad(driver);
            }
        }

        driver.close();
        return result;
    }

    public static List<PlayerDefensiveInfo> crawPlayerDefensive() {
        List<PlayerDefensiveInfo> result = new ArrayList<>();
        //access and wait for web to load
        WebDriver driver = new ChromeDriver();
        driver.get("https://1xbet.whoscored.com/Statistics");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody[id='player-table-statistics-body']")));


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[href='#top-player-stats-defensive']")));
        waitTableLoad(driver);

        while (true) {
            WebElement statisticTable = driver.findElement(By.cssSelector("div[id='top-player-stats-defensive']")).findElement(By.cssSelector("tbody[id='player-table-statistics-body']"));

            List<WebElement> elements = statisticTable.findElements(By.cssSelector("tr"));

            for (WebElement element : elements) {
                try {
                    String name = element.findElement(By.cssSelector("span[class='iconize iconize-icon-left']")).getText();
                    String team = element.findElement(By.cssSelector("span[class='team-name']")).getText();
                    List<WebElement> metaData = element.findElements(By.cssSelector("span[class='player-meta-data']"));
                    String age = metaData.get(0).getText();
                    String position = metaData.get(1).getText();
                    String apps = element.findElements(By.cssSelector("td")).get(2).getText();
                    int minutePlayed;
                    float tacklePerGame, interceptionPerGame, foulsPerGame, offsideWonPerGame, clearancePerGame, wasDribbledPerGame, outFielderBlockPerGame, goalOwn, rating;
                    try {
                        minutePlayed = Integer.parseInt(element.findElement(By.cssSelector("td[class='minsPlayed   ']")).getText());
                    } catch (NumberFormatException e) {
                        minutePlayed = 0;
                    }
                    try {
                        tacklePerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='tacklePerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        tacklePerGame = 0;
                    }
                    try {
                        interceptionPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='interceptionPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        interceptionPerGame = 0;
                    }
                    try {
                        foulsPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='foulsPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        foulsPerGame = 0;
                    }
                    try {
                        offsideWonPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='offsideWonPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        offsideWonPerGame = 0;
                    }

                    try {
                        clearancePerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='clearancePerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        clearancePerGame = 0;
                    }
                    try {
                        wasDribbledPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='wasDribbledPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        wasDribbledPerGame = 0;
                    }
                    try {
                        outFielderBlockPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='outfielderBlockPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        outFielderBlockPerGame = 0;
                    }
                    try {
                        goalOwn = Float.parseFloat(element.findElement(By.cssSelector("td[class='goalOwn   ']")).getText());
                    } catch (NumberFormatException e) {
                        goalOwn = 0;
                    }
                    try {
                        rating = Float.parseFloat(element.findElement(By.cssSelector("td[class='rating   sorted  ']")).getText());
                    } catch (NumberFormatException e) {
                        rating = 0;
                    }
                    System.out.println(name);
                    result.add(new PlayerDefensiveInfo(name, team,age,position, apps, minutePlayed, tacklePerGame, interceptionPerGame, foulsPerGame, offsideWonPerGame, clearancePerGame, wasDribbledPerGame, outFielderBlockPerGame, goalOwn, rating));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            WebElement nextButton = driver.findElement(By.cssSelector("div[id='statistics-paging-defensive']")).findElement(By.id("next"));
            if (nextButton.getAttribute("class").contains("disabled")) {
                System.out.println(nextButton.getAttribute("class"));
                break;
            } else {
                nextButton.click();
                waitTableLoad(driver);
            }
        }

        driver.close();
        return result;
    }

    public static List<PlayerOffensiveInfo> crawPlayerOffensive() {
        List<PlayerOffensiveInfo> result = new ArrayList<>();
        //access and wait for web to load
        WebDriver driver = new ChromeDriver();
        driver.get("https://1xbet.whoscored.com/Statistics");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody[id='player-table-statistics-body']")));


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[href='#top-player-stats-offensive']")));
        waitTableLoad(driver);

        while (true) {
            WebElement statisticTable = driver.findElement(By.cssSelector("div[id='top-player-stats-offensive']")).findElement(By.cssSelector("tbody[id='player-table-statistics-body']"));

            List<WebElement> elements = statisticTable.findElements(By.cssSelector("tr"));

            for (WebElement element : elements) {
                try {
                    String name = element.findElement(By.cssSelector("span[class='iconize iconize-icon-left']")).getText();
                    String team = element.findElement(By.cssSelector("span[class='team-name']")).getText();
                    List<WebElement> metaData = element.findElements(By.cssSelector("span[class='player-meta-data']"));
                    String age = metaData.get(0).getText();
                    String position = metaData.get(1).getText();
                    String apps = element.findElements(By.cssSelector("td")).get(2).getText();
                    int minutePlayed, goal, assistTotal;
                    float shotsPerGame, keyPassPerGame, dribbleWonPerGame, foulGivenPerGame, offsideGivenPerGame, dispossessedPerGame, turnOverPerGame,rating;
                    try {
                        minutePlayed = Integer.parseInt(element.findElement(By.cssSelector("td[class='minsPlayed   ']")).getText());
                    } catch (NumberFormatException e) {
                        minutePlayed = 0;
                    }
                    try {
                        goal = Integer.parseInt(element.findElement(By.cssSelector("td[class='goal   ']")).getText());
                    } catch (NumberFormatException e) {
                        goal = 0;
                    }
                    try {
                        assistTotal = Integer.parseInt(element.findElement(By.cssSelector("td[class='assistTotal   ']")).getText());
                    } catch (NumberFormatException e) {
                        assistTotal = 0;
                    }
                    try {
                        shotsPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='shotsPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        shotsPerGame = 0;
                    }
                    try {
                        keyPassPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='keyPassPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        keyPassPerGame = 0;
                    }
                    try {
                        dribbleWonPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='dribbleWonPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        dribbleWonPerGame = 0;
                    }
                    try {
                        foulGivenPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='foulGivenPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        foulGivenPerGame = 0;
                    }
                    try {
                        offsideGivenPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='offsideGivenPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        offsideGivenPerGame = 0;
                    }
                    try {
                        dispossessedPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='dispossessedPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        dispossessedPerGame = 0;
                    }
                    try {
                        turnOverPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='turnoverPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        turnOverPerGame = 0;
                    }
                    try {
                        rating = Float.parseFloat(element.findElement(By.cssSelector("td[class='rating   sorted  ']")).getText());
                    } catch (NumberFormatException e) {
                        rating = 0;
                    }
                    System.out.println(name);
                    result.add(new PlayerOffensiveInfo(name, team, age, position, apps, minutePlayed, goal, assistTotal, shotsPerGame, keyPassPerGame, dribbleWonPerGame, foulGivenPerGame, offsideGivenPerGame, dispossessedPerGame, turnOverPerGame, rating));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            WebElement nextButton = driver.findElement(By.cssSelector("div[id='statistics-paging-offensive']")).findElement(By.id("next"));
            if (nextButton.getAttribute("class").contains("disabled")) {
                System.out.println(nextButton.getAttribute("class"));
                break;
            } else {
                nextButton.click();
                waitTableLoad(driver);
            }
        }

        driver.close();
        return result;
    }

    public static List<PlayerPassingInfo> crawPlayerPassing() {
        List<PlayerPassingInfo> result = new ArrayList<>();
        //access and wait for web to load
        WebDriver driver = new ChromeDriver();
        driver.get("https://1xbet.whoscored.com/Statistics");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody[id='player-table-statistics-body']")));


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[href='#top-player-stats-passing']")));
        waitTableLoad(driver);

        while (true) {
            WebElement statisticTable = driver.findElement(By.cssSelector("div[id='top-player-stats-passing']")).findElement(By.cssSelector("tbody[id='player-table-statistics-body']"));

            List<WebElement> elements = statisticTable.findElements(By.cssSelector("tr"));

            for (WebElement element : elements) {
                try {
                    String name = element.findElement(By.cssSelector("span[class='iconize iconize-icon-left']")).getText();
                    String team = element.findElement(By.cssSelector("span[class='team-name']")).getText();
                    List<WebElement> metaData = element.findElements(By.cssSelector("span[class='player-meta-data']"));
                    String age = metaData.get(0).getText();
                    String position = metaData.get(1).getText();
                    String apps = element.findElements(By.cssSelector("td")).get(2).getText();
                    int minutePlayed, assistTotal;
                    float keyPassPerGame, totalPassesPerGame, passSuccess, accurateCrossesPerGame, accurateLongPassPerGame, accurateThroughBallPerGame,rating;
                    try {
                        minutePlayed = Integer.parseInt(element.findElement(By.cssSelector("td[class='minsPlayed   ']")).getText());
                    } catch (NumberFormatException e) {
                        minutePlayed = 0;
                    }
                    try {
                        assistTotal = Integer.parseInt(element.findElement(By.cssSelector("td[class='assistTotal   ']")).getText());
                    } catch (NumberFormatException e) {
                        assistTotal = 0;
                    }
                    try {
                        keyPassPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='keyPassPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        keyPassPerGame = 0;
                    }
                    try {
                        totalPassesPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='totalPassesPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        totalPassesPerGame = 0;
                    }
                    try {
                        passSuccess = Float.parseFloat(element.findElement(By.cssSelector("td[class='passSuccess   ']")).getText());
                    } catch (NumberFormatException e) {
                        passSuccess = 0;
                    }
                    try {
                        accurateCrossesPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='accurateCrossesPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        accurateCrossesPerGame = 0;
                    }
                    try {
                        accurateLongPassPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='accurateLongPassPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        accurateLongPassPerGame = 0;
                    }
                    try {
                        accurateThroughBallPerGame = Float.parseFloat(element.findElement(By.cssSelector("td[class='accurateThroughBallPerGame   ']")).getText());
                    } catch (NumberFormatException e) {
                        accurateThroughBallPerGame = 0;
                    }
                    try {
                        rating = Float.parseFloat(element.findElement(By.cssSelector("td[class='rating   sorted  ']")).getText());
                    } catch (NumberFormatException e) {
                        rating = 0;
                    }
                    System.out.println(name);
                    result.add(new PlayerPassingInfo(name, team,age,position,apps,minutePlayed,assistTotal,keyPassPerGame,totalPassesPerGame,passSuccess,accurateCrossesPerGame,accurateLongPassPerGame,accurateThroughBallPerGame,rating));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            WebElement nextButton = driver.findElement(By.cssSelector("div[id='statistics-paging-passing']")).findElement(By.id("next"));
            if (nextButton.getAttribute("class").contains("disabled")) {
                System.out.println(nextButton.getAttribute("class"));
                break;
            } else {
                nextButton.click();
                waitTableLoad(driver);
            }
        }

        driver.close();
        return result;
    }

    public static List<PlayerDetailedInfo> crawPlayerDetail() {
        List<PlayerDetailedInfo> result = new ArrayList<>();
        //access and wait for web to load
        WebDriver driver = new ChromeDriver();
        driver.get("https://1xbet.whoscored.com/Statistics");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody[id='player-table-statistics-body']")));


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[href='#top-player-stats-detailed']")));
        waitTableLoad(driver);

        while (true) {
            WebElement statisticTable = driver.findElement(By.cssSelector("div[id='top-player-stats-detailed']")).findElement(By.cssSelector("tbody[id='player-table-statistics-body']"));

            List<WebElement> elements = statisticTable.findElements(By.cssSelector("tr"));

            for (WebElement element : elements) {
                try {
                    String name = element.findElement(By.cssSelector("span[class='iconize iconize-icon-left']")).getText();
                    String team = element.findElement(By.cssSelector("span[class='team-name']")).getText();
                    List<WebElement> metaData = element.findElements(By.cssSelector("span[class='player-meta-data']"));
                    String age = metaData.get(0).getText();
                    String position = metaData.get(1).getText();
                    String apps = element.findElements(By.cssSelector("td")).get(2).getText();
                    int minutePlayed;
                    float shotsTotal, shotOboxTotal, shotSixYardBox, shotPenaltyArea,rating;

                    try {
                        minutePlayed = Integer.parseInt(element.findElement(By.cssSelector("td[class='minsPlayed   ']")).getText());
                    } catch (NumberFormatException e) {
                        minutePlayed = 0;
                    }

                    try {
                        shotsTotal = Float.parseFloat(element.findElement(By.cssSelector("td[class='shotsTotal   ']")).getText());
                    } catch (NumberFormatException e) {
                        shotsTotal = 0;
                    }
                    try {
                        shotOboxTotal = Float.parseFloat(element.findElement(By.cssSelector("td[class='shotOboxTotal   ']")).getText());
                    } catch (NumberFormatException e) {
                        shotOboxTotal = 0;
                    }
                    try {
                        shotSixYardBox = Float.parseFloat(element.findElement(By.cssSelector("td[class='shotSixYardBox   ']")).getText());
                    } catch (NumberFormatException e) {
                        shotSixYardBox = 0;
                    }
                    try {
                        shotPenaltyArea = Float.parseFloat(element.findElement(By.cssSelector("td[class='shotPenaltyArea   ']")).getText());
                    } catch (NumberFormatException e) {
                        shotPenaltyArea = 0;
                    }
                    try {
                        rating = Float.parseFloat(element.findElement(By.cssSelector("td[class='rating   sorted  ']")).getText());
                    } catch (NumberFormatException e) {
                        rating = 0;
                    }
                    System.out.println(name);
                    result.add(new PlayerDetailedInfo(name, team,age,position, apps,minutePlayed,shotsTotal,shotOboxTotal,shotSixYardBox,shotPenaltyArea,rating));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            WebElement nextButton = driver.findElement(By.cssSelector("div[id='statistics-paging-detailed']")).findElement(By.id("next"));
            if (nextButton.getAttribute("class").contains("disabled")) {
                System.out.println(nextButton.getAttribute("class"));
                break;
            } else {
                nextButton.click();
                waitTableLoad(driver);
            }
        }

        driver.close();
        return result;
    }

    private static void waitTableLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='spinner-container loading-container3']")));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
