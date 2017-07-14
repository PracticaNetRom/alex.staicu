package ro.netrom.summercamp.summercamp2017.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;
import ro.netrom.summercamp.summercamp2017.entity.Category;

@Service
public class AnnouncementService {

	@Autowired
	ObjectMapper mapper;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	HttpHeaders httpHeaders;	
	
	public Announcement getById(Integer id) throws JsonParseException, JsonMappingException, IOException
	{
		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/getById.do?announcementId="+id;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		if (!response.getStatusCode().is2xxSuccessful() || response.getBody().isEmpty())
		{
			return null;
		}
		Announcement announcement = mapper.readValue(response.getBody(), Announcement.class);
		return announcement;
	}
	
	public ArrayList<Announcement> getAnnouncements() throws JsonParseException, JsonMappingException, IOException
	{
		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		if (!response.getStatusCode().is2xxSuccessful() || response.getBody().isEmpty())
		{
			return null;
		}
		
		ArrayList<Announcement> announcements = mapper.readValue(response.getBody(),new TypeReference<ArrayList<Announcement>>(){});
		return announcements;
	}
	
	public boolean addAnnouncement(Announcement announcement)
	{
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		announcement.showInfo();
		HttpEntity<Announcement> entity = new HttpEntity<Announcement>(announcement, httpHeaders);
		ResponseEntity<String> response = restTemplate.postForEntity("http://summercamp.api.stage03.netromsoftware.ro/api/announcement/save.do", entity, String.class);
		
		if(response.getBody().isEmpty() || !response.getStatusCode().is2xxSuccessful())
			return false;
		return true;
	}
	
	public List<Category> getCategories() throws JsonParseException, JsonMappingException, IOException
	{
		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/categories/list.do";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		if (!response.getStatusCode().is2xxSuccessful() || response.getBody().isEmpty())
		{
			return null;
		}
		
		List<Category> categories = mapper.readValue(response.getBody(),new TypeReference<ArrayList<Category>>(){});
		return categories;
	}

	public boolean closeAnnouncement(Integer id, String ownerEmail) {
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/announcement/close.do?id="+id+"&ownerEmail="+ownerEmail;
		ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
		
		if(response.getBody().isEmpty() || !response.getStatusCode().is2xxSuccessful())
			return false;
		return true;
	}
}
