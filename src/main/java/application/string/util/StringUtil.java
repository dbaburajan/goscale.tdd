package application.string.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for all string related operations
 * 
 * @author dbaburajan
 */
public final class StringUtil {

    public static final String EMPTY = "";

    public static final String COMMA_DELIMITER = ",";
    public static final String NEXT_LINE_DELIMITER = "\n";

    public static final String REGEX_OR = "|";

    private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

    private StringUtil() {
        
    }

    /**
     * Check if string is null or empty
     * @param str The string input
     * @return Whether the supplied string is null or empty
     */
    public static boolean isNullOrEmpty(final String str) {
        return ((str == null) || str.isEmpty());
    }

    /**
     * Remove null input from the string
     * @param str The input string whose null
     *         value is to be removed
     * @return The non-null strinng value
     */
    public static String removeNull(final String str) {
        return (StringUtil.isNullOrEmpty(str)) ? StringUtil.EMPTY : str;
    }

    /**
     * Convert the string into integer
     * @param str The string input to convert
     * @return The integer value of the supplied string,
     *         If the string value cannot be converted into
     *         integer, then it will return 0
     */
    public static int convert(final String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return 0;
        }
        try {
            return Integer.valueOf(str);
        } catch (final Exception e) {
            log.error("Failed to convert string to number : " + str);
            return 0;
        }
    }
}
