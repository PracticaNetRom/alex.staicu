package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;
import ro.netrom.summercamp.summercamp2017.entity.Category;
import ro.netrom.summercamp.summercamp2017.filters.FilterManager;
import ro.netrom.summercamp.summercamp2017.filters.FilterWrapper;
import ro.netrom.summercamp.summercamp2017.service.AnnouncementService;

@Controller
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	private SecureRandom random = new SecureRandom();
	private FilterManager filterManager;
	
	@RequestMapping(value="valid_form", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getAnnouncementById(
			@RequestParam(value = "id", required=true) Integer id,
			@RequestParam(value = "code", required=true) String code,
			@RequestParam(value = "ownerEmail", required=true) String ownerEmail
			) throws JsonParseException, JsonMappingException, IOException
	{
		Announcement announcement = announcementService.getById(id);
		Map<String, String> result = new HashMap<String, String>();
		if(announcement.getConfirmationCode().equals(code))
		{
			announcementService.closeAnnouncement(id, ownerEmail);
			result.put("success", "true");
			return result;
		}
		result.put("success", "false");
		return result;
	}
	
	@RequestMapping(value = "/Announcements.html", method = RequestMethod.GET)
	public String showAnnouncements(@ModelAttribute("filterWrapper") FilterWrapper filterWrapper, Model model) throws JsonParseException, JsonMappingException, IOException {
		filterManager = new FilterManager();
		filterManager.addFilter(filterWrapper.getCategoryFilter());
		filterManager.addFilter(filterWrapper.getLocationFilter());
		//filterManager.showInfo();
		//System.out.println(categoryFilter.getFilterValue());
		List<Category> categories = announcementService.getCategories();;
		categories.add(0,new Category(0,"empty","empty"));
		
		model.addAttribute("categories", categories);
		
		ArrayList<Announcement> announcements = announcementService.getAnnouncements();
		announcements = filterManager.getFilter(0).filter(announcements);
		
		TreeSet<String> sortedLocations = getLocations(announcements);
		LinkedHashSet<String> locations = new LinkedHashSet<String>();
		locations.add("empty");
		locations.addAll(sortedLocations);
		
		announcements = filterManager.getFilter(1).filter(announcements);
		/*
		for(int i=0;i<1000;i++)
			announcements.add(new Announcement(
					i,
					"artifficialAdded",
					"artifficialAdded",
					"artifficialAdded",
					false,
					"artifficialAdded",
					new Date(),
					new Date(),
					"artifficialAdded",
					"artifficialAdded",
					"artifficialAdded",
					"2098762341",
					"artifficialAdded",
					"artifficialAdded"
					));
		*/
		int nrAnnouncements=0;
		for(Announcement a:announcements)
			if(!a.isStatus())
				nrAnnouncements++;

		Collections.reverse(announcements);
		model.addAttribute("modelAnnouncements", announcements);
		model.addAttribute("modelDate", new SimpleDateFormat("dd-MM-yyyy"));
		model.addAttribute("numberOfAnnouncements",nrAnnouncements);
		model.addAttribute("locations", locations);

		return "announcements";
	}
	private TreeSet<String> getLocations(ArrayList<Announcement> announcements)
	{
		TreeSet<String> locations = new TreeSet<String>();
		for(int i=0;i<announcements.size();i++)
			if(announcements.get(i).getLocation()!=null && announcements.get(i).isStatus()==false)
				locations.add(announcements.get(i).getLocation());
		
		return locations;
	}
	@ModelAttribute("announcement")
	public Announcement getAnnouncementDTO()
	{
		return new Announcement();
	}
	@RequestMapping(value="/addAnnouncement.html", method=RequestMethod.GET)
	public String addAnnouncement(Model model) throws JsonParseException, JsonMappingException, IOException
	{
		List<Category> categories = announcementService.getCategories();

		if(categories==null)
			return "errorpage";
		model.addAttribute("categories", categories);
		return "addAnnouncement";
	}
	
	@RequestMapping(value="/addAnnouncement.html", method=RequestMethod.POST)
	public String saveAnnouncement(@ModelAttribute("announcement") Announcement announcement,  BindingResult result)
	{
		announcement.setCreateDate(new Date());
		announcement.setConfirmationCode(new BigInteger(200, random).toString(36));
		 if (result.hasErrors()) {
		        return "error";
		  }
		if(announcementService.addAnnouncement(announcement)==false)
			return "error";
		//announcement.showInfo();
		
		return "redirect:/Announcements.html";
	}
/*
	public String closeAnnouncement(Integer id, String ownerEmail, Model model)
	{
		
		if(announcementService.closeAnnouncement(id, ownerEmail)==false)
			return "error";
		return "redirect:/Announcements.html";
	}*/
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");	
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }

}
