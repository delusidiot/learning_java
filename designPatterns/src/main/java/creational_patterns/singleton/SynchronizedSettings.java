package creational_patterns.singleton;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class SynchronizedSettings {
    private static SynchronizedSettings instance;
    private SynchronizedSettings() {

    }

    public static synchronized SynchronizedSettings getInstance() {
        if (instance == null) {
            instance = new SynchronizedSettings();
        }
        return instance;
    }
}
