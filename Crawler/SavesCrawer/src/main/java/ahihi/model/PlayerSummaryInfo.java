package ahihi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LeeHuyyHoangg
 */
@Getter
@AllArgsConstructor
public class PlayerSummaryInfo implements ICsvRecord {
    private String name;
    private String team;
    private String age;
    private String position;
    private String apps;
    private int minutesPlayed;
    private int goal;
    private int assistTotal;
    private int yellowCard;
    private int redCards;
    private float shotsPerGame;
    private float passRate;
    private float aerialWonPerGame;
    private float manOfMatch;
    private float rating;
    @Override
    public Object[] getObjects() {
        return new Object[]{name, team,age, position, apps, minutesPlayed, goal, assistTotal, yellowCard, redCards, shotsPerGame, passRate, aerialWonPerGame, manOfMatch, rating};
    }
}
