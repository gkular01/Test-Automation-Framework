package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

// static is used so that logger will have only one memory allocation.

	// in singleton class, constructor will always be private....
	// when you make constructor private, you cannot create object
	// outside of the class...object can only be created inside of the class.

	private LoggerUtility() {
	}

	public static Logger getLogger(Class<?> clazz) {
		Logger logger=null;
		if (logger == null) {
			logger = LogManager.getLogger(clazz);

		}
		return logger;
	}

}
