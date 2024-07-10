package config;

public class Config {
    public static String BASE_URI;
    public static String MOBILE_APP_PACKAGE;
    public static String MOBILE_APP_ACTIVITY;

    static {
        PropertyManager pm = new PropertyManager();
        BASE_URI = pm.getProperty("base.uri");
        MOBILE_APP_PACKAGE = pm.getProperty("mobile.app.package");
        MOBILE_APP_ACTIVITY = pm.getProperty("mobile.app.activity");
    }
}
