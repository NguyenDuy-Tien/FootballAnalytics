package ahihi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LeeHuyyHoangg
 */
@Getter
@AllArgsConstructor
public class PlayerSavingInfo implements ICsvRecord {
    private String name;
    private String team;
    private String age;
    private String position;
    private String apps;
    private int minutesPlayed;
    private float saveTotal;
    private float saveSixYardBox;
    private float savePenaltyArea;
    private float saveObox;
    private float rating;

    @Override
    public Object[] getObjects() {
        return new Object[]{name, team,age,position, apps, minutesPlayed, saveTotal, saveSixYardBox, savePenaltyArea, saveObox, rating};

    }

}
