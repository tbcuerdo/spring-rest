package com.tbcuerdo.spring.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbcuerdo.spring.rest.domain.Domain;
import com.tbcuerdo.spring.rest.domain.PageObject;

@RestController
@RequestMapping("/controller")
public class Controller {
	
	@Autowired
	private PageObject pageObject;
	
	private Logger logger=LoggerFactory.getLogger(Controller.class);
	
	@RequestMapping(value = "/{refno}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageObject save(@RequestBody Domain domain, @PathVariable("refno") Long id) {
		logger.debug("MCI >> save");
        pageObject.setDomain(domain);
        logger.debug("MCO >> save");
        return pageObject;
    }
			

}
