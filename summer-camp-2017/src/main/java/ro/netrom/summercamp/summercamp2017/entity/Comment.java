package ro.netrom.summercamp.summercamp2017.entity;

import java.util.ArrayList;
import java.util.Date;

public class Comment {
	private Integer id;
	private String content;
	private String name;
	private Integer announcementId;
	private Date createDate;
	private ArrayList<Comment> children = new ArrayList<Comment>();
	private Integer parentId;
	
	
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ArrayList<Comment> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Comment> children) {
		this.children = children;
	}
	public void showInfo() {
		System.out.println("content: "+content+" name: "+name);
	}
	
}
