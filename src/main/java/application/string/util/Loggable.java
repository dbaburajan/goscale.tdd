package application.string.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger interface for it's corresponding implementations
 * 
 * @author dbaburajan
 */
public interface Loggable {

	/**
	 * Get a logger corresponding to the respective class
	 * @return Logger for the called-in class
	 */
	default Logger getLog() {
		return LoggerFactory.getLogger(getClass());
	}
}
