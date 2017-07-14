package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;
import ro.netrom.summercamp.summercamp2017.service.AnnouncementService;

@Controller
public class EmailController {
	@Autowired
	private AnnouncementService announcementService;
	
	
	 @Autowired
	 private JavaMailSender sender;

	 @RequestMapping(value = "/send_email", method=RequestMethod.POST)
	public String sendEmail(@RequestParam(value = "id", required=true) Integer id,@RequestParam(value = "ownerEmail", required=true) String ownerEmail, Model model) throws MessagingException, JsonParseException, JsonMappingException, IOException
	{
		 String confirmationCode = getAnnouncementById(id);
		 
		 MimeMessage message = sender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(message);
		 helper.setTo("staicu.alexandru96@gmail.com");
		 helper.setSubject("Spring mail service");
		 helper.setText("Confirmation code:"+confirmationCode);
		 
		 sender.send(message);
		 
		 model.addAttribute("announcementId", id);
		 model.addAttribute("ownerEmail", ownerEmail);
		 model.addAttribute("confirmationCode",confirmationCode);

		return "deleteAnnouncement";
	}
	 private String getAnnouncementById(Integer id) throws JsonParseException, JsonMappingException, IOException
		{
			Announcement announcement = announcementService.getById(id);
			return announcement.getConfirmationCode();
		}

}
