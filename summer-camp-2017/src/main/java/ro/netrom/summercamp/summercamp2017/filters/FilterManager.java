package ro.netrom.summercamp.summercamp2017.filters;

import java.util.ArrayList;

import ro.netrom.summercamp.summercamp2017.entity.Announcement;

public class FilterManager {
	private ArrayList<Filter> filters = new ArrayList<Filter>();

	public void addFilter(Filter filter) {
			this.filters.add(filter);
	}
	
	public ArrayList<Announcement> filter(ArrayList<Announcement> announcements)
	{
		ArrayList<Announcement> result = announcements;
		for(Filter f:filters)
			result = f.filter(result);
		return result;
	}
	
	public Filter getFilter(int position)
	{
		return filters.get(position);
	}
	
	public void showInfo()
	{
		for(int i=0;i<filters.size();i++)
			System.out.println(filters.get(i).getValue());
	}
}
