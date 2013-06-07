package com.slalom.national.template.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BaseControllerTest {


	private Class<BaseController> typeUnderTest;

	@Before
	public void setUp() throws Exception {
		typeUnderTest = BaseController.class;
	}

	@Test
	public void typeIsAnnotatedAsController() {
		assertNotNull(typeUnderTest.getAnnotation(Controller.class));
	}
	
	@Test
	public void typeIsAnnotatedWithRequestMapping() {
		RequestMapping rm = typeUnderTest.getAnnotation(RequestMapping.class);
		assertNotNull(rm);
		assertEquals("/", rm.value()[0]);
	}
	
	@Test
	public void welcomeAddsMessageAttribute() {
		ModelMap map = new ModelMap();
		assertFalse(map.containsKey("message"));
		
		BaseController underTest = new BaseController();
		
		String returnValue = underTest.welcome(map);
		assertEquals("index", returnValue);
		assertTrue(map.containsAttribute("message"));
		assertEquals("Welcome to a sample REST Service built on Spring", map.get("message"));
	}
	
	@Test
	public void welcomeHandlesRequestsAtExpectedPath() {
		try {
			RequestMapping rm = typeUnderTest.getMethod("welcome", ModelMap.class).getAnnotation(RequestMapping.class);
			assertNotNull(rm);
			assertEquals("/welcome", rm.value()[0]);
			assertEquals(RequestMethod.GET, rm.method()[0]);
		} catch (SecurityException e) {
			e.printStackTrace();
			fail("Security Exception thrown!");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail("NoSuchMethodException thrown!");
		}
	}
	
	@Test
	public void welcomNameAddsMessageAttributeWithNameParameter() {
		//	TODO: Add welcomName method tests
	}
	
	@Test
	public void welcomnameHandlesRequestsAtExpectedPathWithExpectedParameters() {
		//	TODO: Add welcomeName RequestMapping checks
	}
	
}
