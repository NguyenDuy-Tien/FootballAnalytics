package ahihi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerPassingInfo implements ICsvRecord{
    private String name;
    private String team;
    private String age;
    private String position;
    private String apps;
    private int minutesPlayed;
    private int assistTotal;
    private float keyPassPerGame;
    private float totalPassesPerGame;
    private float passSuccess;
    private float accurateCrossesPerGame;
    private float accurateLongPassPerGame;
    private float accurateThroughBallPerGame;
    private float rating;

    @Override
    public Object[] getObjects() {
        return new Object[] {name,team,age, position, apps,minutesPlayed,assistTotal,keyPassPerGame,totalPassesPerGame,passSuccess,accurateCrossesPerGame,accurateLongPassPerGame,accurateThroughBallPerGame, rating};
    }
}
