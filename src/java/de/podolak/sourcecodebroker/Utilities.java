package de.podolak.sourcecodebroker;

/**
 *
 * @author Dude
 */
public class Utilities {

    public static String getI18NText(String key) {
        return java.util.ResourceBundle.getBundle("de/podolak/sourcecodebroker/i18n/LanguageBundle").getString(key);
    }
    
}
