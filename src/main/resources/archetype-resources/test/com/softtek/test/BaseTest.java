package com.softtek.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;


import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockServletContext;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.softtek.service.BaseBusinessServices;
import com.softtek.user.model.Role;
import com.softtek.user.model.UserCredentials;
import com.softtek.user.model.UserProfile;
import com.softtek.user.model.VuUserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-main-context.xml","classpath*:/test-infrastructure-context.xml" })
public abstract class BaseTest {
    protected static MockServletContext context = null;
    protected static MockHttpSession session;
    protected static MockHttpServletRequest request;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected static UserProfile buildUserProfile(final String userName, final Role... roles) {
        return new VuUserProfile(new UserCredentials(userName, ""), Arrays.asList(roles));
    }

    protected void setUserProfile(final Object businessService, final UserProfile userProfile) {
        ((BaseBusinessServices) businessService).setUserProfile(userProfile);
    }

    protected static void iniciar() throws Exception {
        final Map<String, String> filterParams = new HashMap<String, String>();
        if(context == null) {
	        filterParams.put("ActionResolver.Packages",
	                "mx.gob.ventanillaunica.www,com.softtek,ejemplo.stripes");
	        filterParams.put("ActionBeanContext.Class", "com.softtek.controller.BaseControllerContext");
	       // filterParams.put("ExceptionHandler.Class",
	         //       "com.softtek.web.exception.ControllerExceptionHandler");
	        filterParams.put("Interceptor.Classes",
	                "net.sourceforge.stripes.integration.spring.SpringInterceptor");
	        filterParams.put("LocalizationBundleFactory.ErrorMessageBundle",
	                "bundles/controller/error");
	        filterParams.put("LocalizationBundleFactory.FieldNameBundle", "bundles/controller/text");
	        filterParams.put("LocalePicker.Locales", "en,es");
	        filterParams.put("LocalePicker.Class", "com.softtek.web.config.VULocalePicker");
	        filterParams.put("Stripes.EncryptionKey",
	                "hmIJVTpZagqbhEFl2kxBJ65xOjp6pd1sAMzTL6E6Y86hUwzK3haW7cbByEp4viXn");
	        filterParams.put("Extension.Packages",
	                "com.softtek.web.config,org.stripesstuff.plugin,org.stripesbook.reload.extensions");
	        filterParams.put("SecurityManager.Class", "com.softtek.web.security.GlobalSecurityManager");
	        filterParams.put("PopulationStrategy.Class",
	                "net.sourceforge.stripes.tag.BeanFirstPopulationStrategy");
	
	        context = new MockServletContext("authentication");
	        context.addFilter(StripesFilter.class, "StripesFilter", filterParams);
	        context.addInitParameter("contextConfigLocation",
	                "classpath*:/test-main-context.xml");
	
	        final ContextLoaderListener springContextListener = new ContextLoaderListener();
	
	        springContextListener.contextInitialized(new ServletContextEvent(context));
	        context.setServlet(DispatcherServlet.class, "StripesDispatcher", null);
	    }
        startSession();
        startRequest();
    }

    protected static void terminar() throws Exception {
        context.getFilters().get(0).destroy();
        context = null;

        endSession();

        endRequest();
    }

    protected static void startSession() {
        session = new MockHttpSession();
    }

    protected static void endSession() {
        session.clearAttributes();

        session = null;
    }

    protected static void startRequest() {
        request = new MockHttpServletRequest();

        request.setSession(session);

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    protected static void endRequest() {
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).requestCompleted();

        RequestContextHolder.resetRequestAttributes();

        request = null;
    }
}