package it.sevenbits.courses.sm.log;

import java.util.HashMap;
import java.util.Map;

public class MessageFormatter {

    private static final String UNKNOWN_KEY = "Unknown package type";

    /**
     * TYPE -> FORMAT
     * */

    private Map<String, String> stringFormat;

    MessageFormatter() {
        stringFormat = new HashMap<>();
    }

    public String getStringFormatByType(String type){
        String resultValue = stringFormat.get(type);

        if(resultValue == null) {
            return UNKNOWN_KEY;
        }

        return resultValue;
    }

    void update(String type, String format) {
        stringFormat.put(type, format);
    }
}
