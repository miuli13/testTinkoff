package testTask6;

import java.util.ArrayList;
import java.util.List;

public class TestTask6 {
    /**
     * Есть два List<String>. Первый это эталонные ключи, второй это ключи, которые содержатся в БД. Задача: а)
     * проверить, что в БД нет лишних ключей и вывести все лишние ключи б) проверить, что эталонные ключи содержатся
     * в БД и вывести ключи, которых нет в БД.
     */
    public void checkKeys(List<String> standardKeys, List<String> dataBaseKeys) {

        final List<String> firstTaskPart = checkKeysNotStored(dataBaseKeys, standardKeys);
        final List<String> secondTaskPart = checkKeysNotStored(standardKeys, dataBaseKeys);

        System.out.print("first part result is : ");
        if (firstTaskPart!=null) for (String s: firstTaskPart) System.out.print(s);
        System.out.print("\nsecond part result is : ");
        if (secondTaskPart!=null) for (String s: secondTaskPart) System.out.print(s);

    }

    List<String> checkKeysNotStored (List<String> listCheckFrom, List<String> listCheckIn){
        if (listCheckIn == null && listCheckFrom == null) return null;
        if (listCheckIn == null) return listCheckFrom;
        if (listCheckFrom == null) return null;
        if (listCheckIn.size() == 0) return listCheckFrom;
        if (listCheckFrom.size() == 0) return null;

        List<String> result = new ArrayList<String>();

        for (String s: listCheckFrom){
            if (!keyStored(s, listCheckIn)) result.add(s);
        }
        return result;
    }

    private Boolean keyStored(String key, List<String> listToCheckIn) {
        return listToCheckIn.contains(key);
    }
}
