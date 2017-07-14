package ro.netrom.summercamp.summercamp2017.filters;

import java.util.ArrayList;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;

public interface Filter {
	
	public ArrayList<Announcement> filter(ArrayList<Announcement> announcements);

	public String getValue();
}
