package ro.netrom.summercamp.summercamp2017.entity;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementResponseWrapper {

	private List<Announcement> data = new ArrayList<Announcement>();

	public AnnouncementResponseWrapper() {

	}

	public List<Announcement> getData() {
		return data;
	}

	public void setData(List<Announcement> data) {
		this.data = data;
	}
}
