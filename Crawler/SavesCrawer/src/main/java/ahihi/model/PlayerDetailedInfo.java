package ahihi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerDetailedInfo implements ICsvRecord {
    private String name;
    private String team;
    private String age;
    private String position;
    private String apps;
    private int minutesPlayed;
    private float shotsTotal;
    private float shotOboxTotal;
    private float shotSixYardBox;
    private float shotPenaltyArea;
    private float rating;

    @Override
    public Object[] getObjects() {
        return new Object[]{name, team, age, position, apps, minutesPlayed, shotsTotal, shotOboxTotal, shotSixYardBox, shotPenaltyArea, rating};
    }
}
