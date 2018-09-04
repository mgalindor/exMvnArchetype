#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package mx.gob.ventanillaunica.www.${dependencia}.${tramite}.exception;

import com.softtek.exception.BusinessException;

public class ${classTramite}Exception extends BusinessException{

	private static final long serialVersionUID = 4454312381986120608L;

	    private static final String CATEGORY = "${tramite}Exception";

	    public ${classTramite}Exception(final String situation) {
	        super(CATEGORY, situation);
	    }

	    public ${classTramite}Exception(final String situation, final Object... args) {
	        super(CATEGORY, situation, args);
	    }

	    public ${classTramite}Exception(final String situation, final Throwable cause) {
	        super(CATEGORY, situation, cause);
	    }

	    public ${classTramite}Exception(final String situation, final Throwable cause, final Object... args) {
	        super(CATEGORY, situation, cause, args);
	    }
}
