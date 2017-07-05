package ro.netrom.summercamp.summercamp2017.entity;

import java.util.Date;

public class Announcement {
	private Integer id;
	private String title;
	private String content;
	private String location;
	private boolean status;	
	private Integer confirmationCode;
	private Date createDate;
	private Date expireDate;
	private String ownerEmail;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerPhone;
	private String categoryName;
	private String categoryDescription;
	
	

	public Announcement(Integer id, String title, String content, String location, boolean status,
			Integer confirmationCode, Date createDate, Date expireDate, String ownerEmail, String ownerFirstName,
			String ownerLastName, String ownerPhone, String categoryName, String categoryDescription) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.location = location;
		this.status = status;
		this.confirmationCode = confirmationCode;
		this.createDate = createDate;
		this.expireDate = expireDate;
		this.ownerEmail = ownerEmail;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerPhone = ownerPhone;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public Announcement() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(Integer confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public void showInfo() {
		System.out.println("id: " + id);
		System.out.println("titile: " + title);
		System.out.println("content: " + content);
		System.out.println("location: " + location);
		System.out.println("status: " + status);
		System.out.println("confirmationCode: " + confirmationCode);
		System.out.println("createDate: " + createDate);
		System.out.println("expireDate: " + expireDate);
		System.out.println("ownerEmail: " + ownerEmail);
		System.out.println("ownerFirstName: " + ownerFirstName);
		System.out.println("ownerLastName: " + ownerLastName);
		System.out.println("ownerPhone: " + ownerPhone);
		System.out.println("categoryName: " + categoryName);
		System.out.println("categoryDescription: " + categoryDescription);
		System.out.println("--");
	}

}
