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
	
	private static final Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	private StringUtil() {
		
	}

	public static boolean isNullOrEmpty(final String str) {
		return ((str == null) || str.isEmpty());
	}
	
	public static int removeNull(final String str) {
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
