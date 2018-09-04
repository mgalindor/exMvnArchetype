package mx.gob.ventanillaunica.www.${dependencia}.${tramite};

import junit.framework.Assert;
import mx.gob.ventanillaunica.www.${dependencia}.${tramite}.controller.*;
import net.sourceforge.stripes.mock.MockRoundtrip;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.softtek.test.BaseTest;
import com.softtek.user.model.Role;
import com.softtek.user.model.UserProfile;

public class ${classTramite}StripesContextTest extends BaseTest {

    private MockRoundtrip roundTrip;
    @SuppressWarnings("unused")
    private UserProfile userProfile;

    @Before
    public void setUp() throws Exception {
        iniciar();
        logger.debug("context: [{}]", context);
        userProfile = buildUserProfile("CERM20110101AAA", new Role(
                "RepresentanteLegal"));
    }

    @After
    public void tearDown() throws Exception {
        terminar();
        roundTrip = null;
    }

    @Test
    public final void test${classTramite}() {
        roundTrip = new MockRoundtrip(context, ${classTramite}Controller.class);
        logger.debug("roundTrip: [{}]", roundTrip);
        ${classTramite}Controller controller;

        try {
            roundTrip.execute();
        } catch (Exception e1) {
            logger.debug("error");
        }

        controller = roundTrip.getActionBean(${classTramite}Controller.class);

        logger.debug("Controller[{}]", controller);
        Assert.assertTrue(controller!= null);
    }

}