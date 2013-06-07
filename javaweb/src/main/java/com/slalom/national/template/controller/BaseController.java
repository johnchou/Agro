package com.slalom.national.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author garyk
 * Simple REST controller used as a sample.  Built on Spring
 */
@Controller
@RequestMapping("/")
public class BaseController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap map) {
		map.addAttribute("message", "Welcome to a sample REST Service built on Spring");
		return "index";
	}
}
