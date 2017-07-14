package ro.netrom.summercamp.summercamp2017.filters;

public class FilterWrapper {
	private CategoryFilter categoryFilter = new CategoryFilter();
	private LocationFilter locationFilter = new LocationFilter();
	public CategoryFilter getCategoryFilter() {
		return categoryFilter;
	}
	public void setCategoryFilter(CategoryFilter categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	public LocationFilter getLocationFilter() {
		return locationFilter;
	}
	public void setLocationFilter(LocationFilter locationFilter) {
		this.locationFilter = locationFilter;
	}
	
}
