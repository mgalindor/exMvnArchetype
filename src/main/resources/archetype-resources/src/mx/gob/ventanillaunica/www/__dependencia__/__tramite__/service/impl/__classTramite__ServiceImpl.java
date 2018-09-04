#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package mx.gob.ventanillaunica.www.${dependencia}.${tramite}.service.impl;

import mx.gob.ventanillaunica.www.${dependencia}.${tramite}.service.${classTramite}Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("${classTramite}Service")
@Scope("session")
public class ${classTramite}ServiceImpl implements ${classTramite}Service{

	
}
