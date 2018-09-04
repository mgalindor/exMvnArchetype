#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package mx.gob.ventanillaunica.www.${dependencia}.${tramite}.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(serviceName = "${classTramite}EndPoint")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public class ${classTramite}EndPoint extends SpringBeanAutowiringSupport {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@WebMethod(operationName = "holaMundo")
	public String holaMundo(
			@WebParam(name = "mensaje") byte[] mensaje) {
		logger.debug("mensaje [{}]",new String (mensaje));
		return new String (mensaje);
	}

}