package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;

@Controller
public class IndexController {
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	RestTemplate restTemplate;
	

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String getIndex() {
		return "test";
	}

	@RequestMapping(value = "/Announcements.html", method = RequestMethod.GET)
	public String showAnnouncements(Model model) throws JsonParseException, JsonMappingException, IOException {
		
		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		if (!response.getStatusCode().is2xxSuccessful() || response.getBody().isEmpty())
		{
			return "errorPage";
		}
		
		List<Announcement> announcements = mapper.readValue(response.getBody(),new TypeReference<ArrayList<Announcement>>(){});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		announcements.add(new Announcement(
				 new Integer(1), 
				 "Vand masina modelul nu il stiu pretul cat vreau eu si trebuie sa fac titlul mai lung Vand masina modelul nu il stiu pretul cat vreau eu si trebuie sa fac titlul mai lung", 
				 "Nikola Tesla (în sârbă Никола Тесла; n. 10 iulie 1856,[1] Smiljan, Imperiul Austriac[2] – d. 7 ianuarie 1943,[2][1] New York, SUA[3]) a fost un inventator, fizician, inginer mecanic, inginer electrician și unul dintre promotorii cei mai importanți ai electricității comerciale. Tesla este considerat ca fiind un important om de știință al sfârșitului de secol XIX și începutului de secol XX. Invențiile, precum și munca teoretică ale lui Tesla au pus bazele cunoștințelor moderne despre curentul alternativ, puterea electrică, sistemele de curent alternativ, incluzând sistemele polifazice, sistemele de distribuție a puterii și motorul pe curent alternativ, care au determinat cea de-a doua Revoluție Industrială.", 
				 "location", 
				 false, 
				 12321, 
				 new Date(01/01/1999), 
				 new Date(05/05/1999), 
				 "emailadgeadzbgfsnhtjdyfhnbgdfsaeqagrystedyrjfkuhmncbgbsrlargeasfgdbshftjeujhfblarge", 
				 "FirstName", 
				 "LastName", 
				 "123456789123456", 
				 "Category", 
				 "CategoryDescription"));

		announcements.add(new Announcement(
				 new Integer(1), 
				 "title", 
				 "content asd s a  asd asd", 
				 "location", 
				 false, 
				 12321, 
				 new Date(),
				 new Date(), 
				 "asdfghjklqwertyuiopz@gmail.com", 
				 "Staicu", 
				 "Nicolae Alexandru", 
				 "Phone", 
				 "CategoryName", 
				 "CategoryDescryptionasf asf asf fasfqfqef qeaf afqeasf aefsasf asf asf aefs eaf asfasf asf asf asf "));

		for (int i = 0; i < announcements.size(); i++)
			announcements.get(i).showInfo();
		
		model.addAttribute("modelAnnouncements", announcements);
		model.addAttribute("modelDate", dateFormat);

		return "test";
	}
	
	@RequestMapping(value="/addAnnouncement.html", method=RequestMethod.GET)
	public String addAnnouncement()
	{
		return "addAnnouncement";
	}
	
	
}
