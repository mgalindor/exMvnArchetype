#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package mx.gob.ventanillaunica.www.${dependencia}.${tramite}.constants;

import com.softtek.global.constant.JspPagesConstants;

public interface ${classTramite}JspPagesConstants extends JspPagesConstants {

	String APP_BASE_DIRECTORY_${tramite} = APP_BASE_DIRECTORY + "${dependencia}/${tramite}";
	String REGISTRAR_SOLICITUD = APP_BASE_DIRECTORY_${tramite} + "registro/capturar.jsp";
}