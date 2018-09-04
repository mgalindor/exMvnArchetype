package mx.gob.ventanillaunica.www.${dependencia}.${tramite};

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.gob.ventanillaunica.www.${dependencia}.${tramite}.helper.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-main-context.xml" })
public class ${classTramite}Test {

	@Autowired
	${classTramite}Helper helper;
	
	
	@Test
	public void test${tramite}(){
		
		Assert.assertNotNull("Objeto nulo" , helper);
		
	}
	
}
