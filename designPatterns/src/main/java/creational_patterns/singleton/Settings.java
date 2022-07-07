package creational_patterns.singleton;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class Settings {

    private static Settings instance;
    private Settings() {

    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
