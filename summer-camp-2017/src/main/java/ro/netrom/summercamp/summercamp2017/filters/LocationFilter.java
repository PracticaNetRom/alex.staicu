package ro.netrom.summercamp.summercamp2017.filters;

import java.util.ArrayList;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;

public class LocationFilter implements Filter {
	private String filterLocationValue;
	
	@Override
	public ArrayList<Announcement> filter(ArrayList<Announcement> announcements) {
		if(filterLocationValue==null || filterLocationValue.equals("empty"))
			return announcements;
		ArrayList<Announcement> filteredAnnouncements = new ArrayList<Announcement>();
		for(Announcement a:announcements)
			if(a.getLocation()!=null && a.getLocation().equals(filterLocationValue))
				filteredAnnouncements.add(a);
		return filteredAnnouncements;
	}
	

	public String getFilterLocationValue() {
		return filterLocationValue;
	}


	public void setFilterLocationValue(String filterLocationValue) {
		this.filterLocationValue = filterLocationValue;
	}


	@Override
	public String getValue() {
		return filterLocationValue;
	}
}
