package architecture.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;

import utils.ResponseGenerator;

public class TestArchitectureResponseVerificationService {
	
	//Se verifica que todas las clases en web service extiendan de ResponseGenerator
	
	@Test
	public void testShouldAllClassesExtendsFromResponseGenerator() {
		String pack = "webservice"; 
		int classWithResponseGenerator = 0;
		int totalClassesInPackage= 4;
		
		Object[] classes = this.getAllClassesWith(ResponseGenerator.class,pack);
		classWithResponseGenerator = classes.length;
		Assert.assertEquals(totalClassesInPackage,classWithResponseGenerator);
	}
	
	@Test
	public void testPUTShouldReturnAResponse() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String pack = "webservice"; 
		
		Object[] classes = this.getAllClassesWith(ResponseGenerator.class,pack);
		for(Object oClass:classes){
			Object instance = instanceClass(oClass);
			List<Method> methods = getMethodsAnnotatedWith(instance.getClass(),PUT.class);
			for (Method method:methods){
				Assert.assertEquals(method.getReturnType().getSimpleName(),"Response");
			}
		}
	}
	
	@Test
	public void testPOSThouldReturnAResponse() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String pack = "webservice"; 
		
		Object[] classes = this.getAllClassesWith(ResponseGenerator.class,pack);
		for(Object oClass:classes){
			Object instance = instanceClass(oClass);
			List<Method> methods = getMethodsAnnotatedWith(instance.getClass(),POST.class);
			for (Method method:methods){
				Assert.assertEquals(method.getReturnType().getSimpleName(),"Response");
			}
		}
	}
	
	@Test
	public void testDELETEShouldReturnAResponse() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String pack = "webservice"; 
		
		Object[] classes = this.getAllClassesWith(ResponseGenerator.class,pack);
		for(Object oClass:classes){
			Object instance = instanceClass(oClass);
			List<Method> methods = getMethodsAnnotatedWith(instance.getClass(),DELETE.class);
			for (Method method:methods){
				Assert.assertEquals(method.getReturnType().getSimpleName(),"Response");
			}
		}
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object[] getAllClassesWith(Class pclass, String pPackage) {

		Reflections reflections = new Reflections(pPackage);
		Object[] allclass = reflections.getSubTypesOf(pclass).toArray();
		return allclass;

	}
	
	public Object instanceClass(final Object oClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String rawclassName = oClass.toString();
		String className = rawclassName.substring(rawclassName.indexOf(" ") +1  , rawclassName.length());
		Class<?> c = Class.forName(className);
		Object instance = c.newInstance();
		return instance;
	}
	
	public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
	    final List<Method> methods = new ArrayList<Method>();
	    Class<?> klass = type;
	    while (klass != Object.class) {
	        final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));       
	        for (final Method method : allMethods) {
	            if (method.isAnnotationPresent(annotation)) {
	                methods.add(method);
	            }
	        }
	        klass = klass.getSuperclass();
	    }
	    return methods;
	}
	
}
