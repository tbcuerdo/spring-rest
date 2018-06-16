package com.tbcuerdo.spring.rest.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tbcuerdo.spring.rest.domain.PageObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
@WebAppConfiguration
public class PageObjectTest {

	@Autowired
	private PageObject pageObject;

	@Test
	public void test() {
		assertNotNull(pageObject);
		String displayProp1 = pageObject.displayProp1();
		assertNotNull(displayProp1);
	}

}
