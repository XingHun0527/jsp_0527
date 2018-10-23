package com.briup.jsp.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener, ServletContextAttributeListener {



    public void contextDestroyed(ServletContextEvent paramServletContextEvent)  { 
        
    		System.out.println("....application...destoryed..");
    }


    public void contextInitialized(ServletContextEvent paramServletContextEvent)  { 
    
    		System.out.println("..application..init.....");
    }


	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
	
		
	}


	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
	
		
	}


	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
	
		
	}
	
}
