package ro.netrom.summercamp.summercamp2017.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ro.netrom.summercamp.summercamp2017.entity.Comment;
import ro.netrom.summercamp.summercamp2017.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/root", method = RequestMethod.GET)
	public String showComment(@RequestParam(value = "announcementId", required=true) Integer announcementId, Model model) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Comment> comments = commentService.getComments(announcementId);
		if(comments==null)
		{
			return "error";
		}
		model.addAttribute("node", comments);
		model.addAttribute("clsComm", "even");
		model.addAttribute("dateFormatDay", new SimpleDateFormat("dd-MM-yyyy"));
		model.addAttribute("dateFormatClock", new SimpleDateFormat("HH:mm:ss"));
		model.addAttribute("announcementId", announcementId);
		return "root";
	}
	@ModelAttribute("comment")
	public Comment getComment()
	{
		return new Comment();
	}
	@RequestMapping(value="/comments", method=RequestMethod.POST)
	public String addComment(@ModelAttribute("comment") Comment comment,  BindingResult result)
	{
		comment.setCreateDate(new Date());
		if(commentService.addComment(comment)==false)
			return "error";
		return "redirect:/root?announcementId="+comment.getAnnouncementId();
	}

}
