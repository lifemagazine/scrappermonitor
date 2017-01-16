package com.lifemagazine.scrappermonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.ScrapperInfo;
import com.lifemagazine.scrappermonitor.repository.ScrapperInfoRepository;
import com.lifemagazine.scrappermonitor.util.Utility;

@Component
public class ScrapperInfoService {

	@Autowired(required=true)
	ScrapperInfoRepository service;
	
	public List<ScrapperInfo> findAll() {
		// TODO Auto-generated method stub
		return (List<ScrapperInfo>) service.findAll();
	}
	
	public Page<ScrapperInfo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAll(pageable);
	}
	
	public ScrapperInfo findOne(Integer id) {
        return service.findOne(id);
    }
	
	public ScrapperInfo save(ScrapperInfo scrapperInfo) {
		return service.save(scrapperInfo);
	}
	
	public void delete(Integer scrapperId) {
		service.delete(scrapperId);
	}
	
	public ScrapperInfo update(Integer scrapperId, ScrapperInfo scrapperInfo) {
		ScrapperInfo update = service.findOne(scrapperId);
		update.setScrapperName(scrapperInfo.getScrapperName());
		update.setScrapperDesc(scrapperInfo.getScrapperDesc());
		update.setScrapperType(scrapperInfo.getScrapperType());
		update.setOperId(scrapperInfo.getOperId());
		update.setScrapCyle(scrapperInfo.getScrapCyle());
		update.setModifyUser(scrapperInfo.getModifyUser());
		update.setModifyDate(Utility.getCurrentTime(null));
		return service.save(update);
	}
}
