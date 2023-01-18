package ahihi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerDefensiveInfo implements ICsvRecord {
    private String name;
    private String team;
    private String age;
    private String position;
    private String apps;
    private int minutesPlayed;
    private float tacklePerGame;
    private float interceptionPerGame;
    private float foulsPerGame;
    private float offsideWonPerGame;
    private float clearancePerGame;
    private float wasDribbledPerGame;
    private float outFielderBlockPerGame;
    private float goalOwn;
    private float rating;

    @Override
    public Object[] getObjects() {
        return new Object[]{name, team,age,position, apps, minutesPlayed, tacklePerGame, interceptionPerGame, foulsPerGame,offsideWonPerGame,clearancePerGame,wasDribbledPerGame,outFielderBlockPerGame,goalOwn, rating};

    }
}
