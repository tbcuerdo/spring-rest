package gov.bsp.lcmis.internal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbcuerdo.spring.rest.domain.ListOfMaturingPNs;
import com.tbcuerdo.spring.rest.domain.persistence.RetrieveMaturingPNsDao;
import com.tbcuerdo.spring.rest.domain.persistence.RetrieveMaturingPNsRepo.Item;

@RestController
@RequestMapping("/items")
public class ListOfItemsController {

	@Autowired
	RetrieveItemsDao dao;
	
	private static Logger log = LoggerFactory.getLogger(ListOfItemsController.class);
	
	@PostMapping
	@ResponseBody
	public List<Item> getItems(@RequestBody ListOfItems crit) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("MCI >> getItems");
		}
		
		List<Item> items = dao.retrieveItems(crit);
		
		if(log.isDebugEnabled()) {
			log.debug("MCO >> getItems");
		}
		return items;
	}
	
}