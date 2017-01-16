package com.lifemagazine.scrappermonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrappermonitor.domain.ScrapperInfo;
import com.lifemagazine.scrappermonitor.service.ScrapperInfoService;

@RestController
@RequestMapping("api/scrapperinfo")
public class ScrapperInfoRestController {

	@Autowired
	private ScrapperInfoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<ScrapperInfo> list(@PageableDefault Pageable pageable) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(new Order(Direction.DESC, "modifyUser")));
		return (Page<ScrapperInfo>) service.findAll(pageRequest);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	ScrapperInfo getScrapperInfo(@PathVariable Integer scrapperId) {
		ScrapperInfo scrapperInfo = service.findOne(scrapperId);
        return scrapperInfo;
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public ScrapperInfo create(@RequestBody ScrapperInfo scrapperInfo) {
		return service.save(scrapperInfo);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="{scrapper_id}")
	public void delete(@PathVariable Integer scrapperId) {
		service.delete(scrapperId);
	}

	@RequestMapping(method=RequestMethod.PUT, value="{scrapper_id}")
	public ScrapperInfo update(@PathVariable Integer scrapperId, @RequestBody ScrapperInfo scrapperInfo) {
		return service.update(scrapperId, scrapperInfo);
	}
}
