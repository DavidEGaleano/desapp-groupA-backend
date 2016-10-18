package builders;

import model.LogSystem;
import model.System;

public class SystemBuilder {
	
	public LogSystem logSystem = new LogSystem();
	
	public System build(){
		System aSystem = new System(logSystem);
		return aSystem;
	}
	
	public SystemBuilder withLogSystem(LogSystem aLogSys){
		logSystem = aLogSys;
		return this;
	}
	
}
