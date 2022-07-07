package creational_patterns.singleton;

/**
 * author       : delusidiot
 * date         : 2022-07-07
 */
public class StaticInnerClassSettings {

    private StaticInnerClassSettings() {

    }

    private static class SettingsHolder {
        private static final StaticInnerClassSettings INSTANCE = new StaticInnerClassSettings();
    }

    public static StaticInnerClassSettings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
