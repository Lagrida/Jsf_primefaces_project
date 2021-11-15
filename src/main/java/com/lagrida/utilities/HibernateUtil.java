package com.lagrida.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static EntityManagerFactory factory;
	static{
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("yassine");
		}
	}
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
