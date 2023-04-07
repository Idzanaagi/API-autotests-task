package pojo.limitedList;

public class ResultsItem {

	public ResultsItem(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public ResultsItem() {
		super();
	}

	private String name;
	private String url;

	public String getName(){
		return name;
	}
	public String getUrl(){
		return url;
	}
}