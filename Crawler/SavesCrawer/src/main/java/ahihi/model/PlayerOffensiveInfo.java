package ahihi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerOffensiveInfo implements ICsvRecord{
    private String name;
    private String team;
    private String age;
    private String position;
    private String apps;
    private int minutesPlayed;
    private int goal;
    private int assistTotal;
    private float shotsPerGame;
    private float keyPassPerGame;
    private float dribbleWonPerGame;
    private float foulGivenPerGame;

    private float offsideGivenPerGame;
    private float dispossessedPerGame;
    private float turnOverPerGame;
    private float rating;

    @Override
    public Object[] getObjects() {
        return new Object[]{name, team,age, position, apps, minutesPlayed, goal, assistTotal, shotsPerGame, keyPassPerGame, dribbleWonPerGame, foulGivenPerGame,offsideGivenPerGame,dispossessedPerGame,turnOverPerGame, rating};
    }
}
