package pojo.limitedList;

import java.util.List;

public class ResponseData {

	public ResponseData(String next, Object previous, int count, List<ResultsItem> results) {
		this.next = next;
		this.previous = previous;
		this.count = count;
		this.results = results;
	}

	public ResponseData() {
		super();
	}

	private String next;
	private Object previous;
	private int count;
	private List<ResultsItem> results;

	public String getNext(){
		return next;
	}
	public Object getPrevious(){
		return previous;
	}
	public int getCount(){
		return count;
	}
	public List<ResultsItem> getResults(){
		return results;
	}
}