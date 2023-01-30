package ahihi.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface ICsvRecord {
    default String[] getHeaders(){
        List<String> result = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            result.add(field.getName());
        }

        return result.toArray(new String[0]);
    }
    Object[] getObjects();
}
