package creational_patterns.singleton;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class DoubleCheckedLockingSettings {

    private static volatile DoubleCheckedLockingSettings instance;
    private DoubleCheckedLockingSettings() {

    }

    public static DoubleCheckedLockingSettings getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSettings.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSettings();
                }
            }
        }
        return instance;
    }
}
