package com.sinensia.juegos04.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.persistence.Id;



public class JuegosUtils {
	
	public static String getPKColumnName(Class<?> pojo) {

	    if (pojo == null) 
	        return null;

	    String name = null;

	    for (Field f : pojo.getDeclaredFields()) {

	        Annotation[] as = f.getAnnotations();
	        
	        for (Annotation a : as) {
	        	
	            if (a.annotationType() == Id.class) {
	            	name = f.getName();
	            	break;

	            }
	            
	        }
	    }

	    if (name == null && pojo.getSuperclass() != Object.class)
	        name = getPKColumnName(pojo.getSuperclass());

	    return name;
	}
	
}


