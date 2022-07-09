package org.baseclass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class Slf4j {
	
	static Logger Log;
	
	public static Logger loadlogger(Class<?> name) {
		Log = LoggerFactory.getLogger(name);
		
		return Log;
	}

}
