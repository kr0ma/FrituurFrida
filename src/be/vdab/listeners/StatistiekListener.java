package be.vdab.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class StatistiekListener
 *
 */
@WebListener
public class StatistiekListener implements ServletRequestListener,ServletContextListener {
	//private static final String STATISTIEK = "statistiek";
	//private final static Set<String> UITGESLOTEN_EXTENSIES = new CopyOnWriteArraySet<>(Arrays.asList("jpg","png","css","js", "ico","gif"));
	

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event)  { 
         
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  { 
    	/*
    	if (event.getServletRequest() instanceof HttpServletRequest){
    		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
    		String url = request.getRequestURI();    		
    		Boolean verwerkRequest = true;
    		int laatstePuntIndex = url.lastIndexOf('.');
    		if (laatstePuntIndex != -1){
    			String extensie = url.substring(laatstePuntIndex + 1).toLowerCase();
    			if (UITGESLOTEN_EXTENSIES.contains(extensie)){
    				verwerkRequest = false;
    			}
    		}
    		if (verwerkRequest){    			
    			@SuppressWarnings("unchecked")
                ConcurrentHashMap<String, AtomicInteger> statistiek = (ConcurrentHashMap<String, AtomicInteger>) request.getServletContext().getAttribute(STATISTIEK);
    			AtomicInteger aantalReedsAanwezig = statistiek.putIfAbsent(url, new AtomicInteger(1));    			
        		if (aantalReedsAanwezig != null){
        			aantalReedsAanwezig.incrementAndGet();
        		}
    		}            	
    	}   
    	*/      
    }

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//event.getServletContext().setAttribute(STATISTIEK, new ConcurrentHashMap<String, AtomicInteger>());		
	}
	
}
