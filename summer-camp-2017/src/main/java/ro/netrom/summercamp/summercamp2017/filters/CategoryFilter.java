package ro.netrom.summercamp.summercamp2017.filters;


import java.util.ArrayList;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;

public class CategoryFilter implements Filter {
	private String filterCategoryValue;
	
	@Override
	public ArrayList<Announcement> filter(ArrayList<Announcement> announcements) {
		if(filterCategoryValue==null || filterCategoryValue.equals("empty"))
			return announcements;
		ArrayList<Announcement> filteredAnnouncements = new ArrayList<Announcement>();
		for(Announcement a:announcements)
			if(a.getCategoryName().equals(filterCategoryValue))
				filteredAnnouncements.add(a);
		return filteredAnnouncements;
	}


	public String getFilterCategoryValue() {
		return filterCategoryValue;
	}


	public void setFilterCategoryValue(String filterCateogoryValue) {
		this.filterCategoryValue = filterCateogoryValue;
	}

	@Override
	public String getValue() {
		return filterCategoryValue;
	}
}
