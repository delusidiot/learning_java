package creational_patterns.singleton;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class EagerInitializationSettings {
    private static final EagerInitializationSettings INSTANCE = new EagerInitializationSettings();
    private EagerInitializationSettings() {

    }

    public static EagerInitializationSettings getInstance() {
        return INSTANCE;
    }
}
