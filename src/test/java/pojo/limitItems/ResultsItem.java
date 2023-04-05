package pojo.limitItems;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsItem{
	public ResultsItem(String name, String url) {
		this.name = name;
		this.url = url;
	}
	public ResultsItem() {
		super();
	}

	@JsonProperty("name")
	private String name;
	@JsonProperty("url")
	private String url;

	public String getName(){
		return name;
	}
	public String getUrl(){
		return url;
	}
}