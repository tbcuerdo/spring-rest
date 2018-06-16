package com.tbcuerdo.spring.rest.controller;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
@Profile("test")
public abstract class BaseWebApplicationContextTests {
    protected DispatcherServlet servlet;

    @Resource
    protected ApplicationContext applicationContext;

    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    @Before
    public  void initDispatcherServlet() throws Exception{
        servlet = new DispatcherServlet() {
			private static final long serialVersionUID = 1L;

			@Override
            protected  WebApplicationContext createWebApplicationContext(
                    WebApplicationContext parent) throws BeansException {

                GenericWebApplicationContext gwac = new GenericWebApplicationContext();
                gwac.setParent(applicationContext);
                gwac.refresh();
                return gwac;
            }
        };

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        
        MockServletContext servletContext = new MockServletContext("src/main/java", new FileSystemResourceLoader());

        servlet.init(new MockServletConfig(servletContext));
    }
}
