package com.lagrida;

import java.util.Map;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lagrida.utilities.HibernateUtil;

public class ApplicationStart implements SystemEventListener{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static int counter = 0;
	@Override
	public boolean isListenerForSource(Object source) {
		return source instanceof Application;
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		counter++;
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> applicationMap = context.getExternalContext().getApplicationMap();
		if (event instanceof PostConstructApplicationEvent && counter == 1) {
			EntityManager entityManager = HibernateUtil.getEntityManager();
			logger.info("System Event : PostConstructApplicationEvent");
		}
	}
}
