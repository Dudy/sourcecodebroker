package de.podolak.sourcecodebroker.util;

/**
 *
 * @author Dude
 */
public class Utilities {

    public static String getI18NText(String key) {
        return java.util.ResourceBundle.getBundle("de/podolak/sourcecodebroker/i18n/LanguageBundle").getString(key);
    }
    
    public static String formatCodeTemplate(String codeTemplate) {
        return codeTemplate
                .replace("{", "{\n")
                .replace(";", ";\n")
                .replace("}", "}\n");
    }
    
}
