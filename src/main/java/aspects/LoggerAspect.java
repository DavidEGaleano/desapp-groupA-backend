package aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class LoggerAspect {
	
	
		private static Logger log = Logger.getLogger(LoggerAspect.class.getName());

	    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	    String nameMethod = signature.getMethod().getName();
	    String arguments = Arrays.toString(joinPoint.getArgs());
		log.info("----------- Method " + nameMethod + " has started-------------");
		log.info("----------- Arguments are: " + arguments + "-------------");
		Long startTime = System.currentTimeMillis();
		Object response = joinPoint.proceed(); 
		Long finishTime = System.currentTimeMillis();
		Long completionTime = finishTime - startTime;
		log.info("----------- Method " + nameMethod + " has ended ------------- ");
		log.info("----------- CompletionTime : "+ completionTime +" (ms) ---------");
		return response;
	   }
}
