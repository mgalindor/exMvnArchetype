#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package mx.gob.ventanillaunica.www.${dependencia}.${tramite}.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	List<String> errors ;
	
	public SimpleErrorHandler() {
		errors = new ArrayList<String>();
	}
	
    public void warning(SAXParseException e) {
    	errors.add(e.getMessage());
        logger.debug("[{}] : {}",e.getLineNumber(),e.getMessage());
    }

    public void error(SAXParseException e) {
    	errors.add(e.getMessage());
    	logger.debug("[{}] : {}",e.getLineNumber(),e.getMessage());
    }

    public void fatalError(SAXParseException e) {
    	errors.add(e.getMessage());
    	logger.debug("[{}] : {}",e.getLineNumber(),e.getMessage());
    }
    
    public List<String> getErrors() {
		return errors;
	}
    
    public boolean tieneErrores()
    {
    	return !errors.isEmpty();
    }
}
