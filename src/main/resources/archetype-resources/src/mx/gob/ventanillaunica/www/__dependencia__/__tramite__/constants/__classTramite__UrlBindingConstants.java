#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package mx.gob.ventanillaunica.www.${dependencia}.${tramite}.constants;

import com.softtek.global.constant.ControllerUrlBindingConstants;

public interface ${classTramite}UrlBindingConstants extends ControllerUrlBindingConstants{

	String BASE_URL = ACTION_PREFIX + "${dependencia}/${tramite}";
	
	String REGISTRO_SOLICITUD_ = BASE_URL + "${tramite}Wizard" + ACTION_SUFFIX;
	
	
}
