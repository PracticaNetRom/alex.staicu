package ro.netrom.summercamp.summercamp2017.service;

import java.io.IOException;
import java.util.ArrayList;

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

import ro.netrom.summercamp.summercamp2017.entity.Comment;

@Service
public class CommentService {
	@Autowired
	ObjectMapper mapper;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	HttpHeaders httpHeaders;
	
	public ArrayList<Comment> getComments(Integer announcementId) throws JsonParseException, JsonMappingException, IOException
	{
		String url = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/list.do?announcementId="+announcementId;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		if (!response.getStatusCode().is2xxSuccessful() || response.getBody().isEmpty())
		{
			return null;
		}
		
		ArrayList<Comment> comments = mapper.readValue(response.getBody(),new TypeReference<ArrayList<Comment>>(){});
		return comments;
	}
	
	public boolean addComment(Comment comment)
	{
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		comment.setContent(comment.getContent().replaceAll("\r\n", "<br>"));
		HttpEntity<Comment> entity = new HttpEntity<Comment>(comment, httpHeaders);
		String url = new String();
		if(comment.getParentId()!=null)
		{
			url = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/save.do?announcementId="+comment.getAnnouncementId()+"&parentId="+comment.getParentId();
		}
		else
		{
			url = "http://summercamp.api.stage03.netromsoftware.ro/api/comments/save.do?announcementId="+comment.getAnnouncementId();
		}
			//String url = "http://192.168.169.46:17281/comments/save.do?announcementId="+comment.getAnnouncementId()+"&parentId="+comment.getParentId();
		
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		
		if(response.getBody().isEmpty() || !response.getStatusCode().is2xxSuccessful())
			return false;
		return true;
	}

}
