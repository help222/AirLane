package mod2;

import java.util.ArrayList;
import java.util.List;

public class Towns {
    private static String[] towns = {
            "Вінниця",
            "Дніпропетровськ",
            "Донецьк",
            "Житомир",
            "Запоріжжя",
            "Івано-Франківськ",
            "Київ",
            "Кіровоград",
            "Луганськ",
            "Луцьк",
            "Львів",
            "Миколаїв",
            "Одеса",
            "Полтава",
            "Рівне",
            "Суми",
            "Тернопіль",
            "Ужгород",
            "Харків",
            "Херсон",
            "Хмельницький",
            "Черкаси",
            "Чернівці",
            "Чернігів",
    };

    public static List<String> TownList() {
        List<String> townList = new ArrayList<String>();
        for (int i = 0; i < towns.length; i++) {
            townList.add(towns[i]);
        }
        return townList;
    }
}
