package com.bullhornsdk.data.model.parameter.standard;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bullhornsdk.data.model.parameter.SearchParams;

public class StandardSearchParams implements SearchParams {

	private boolean showEditable;

	private Integer count;

	private Integer start;

	private String sort;

	private StandardSearchParams() {
		super();
		this.showEditable = false;
		this.count = 20;
		this.start = null;
		this.sort = null;
	}

	public static StandardSearchParams getInstance() {
		StandardSearchParams params = new StandardSearchParams();
		return params;
	}

	public void setShowEditable(boolean showEditable) {
		this.showEditable = showEditable;

	}

	
	public Integer getCount() {
		return count;
	}

	
	public void setCount(Integer count) {
		this.count = count;
	}

	
	public void setStart(Integer start) {
		this.start = start;
	}

	
	public Integer getStart() {
		return start;
	}

	
	public String getSort() {
		return sort;
	}

	
	public void setSort(String sort) {
		this.sort = sort;
	}

	
	public String getUrlString() {
		StringBuilder url = new StringBuilder();

		if (showEditable != false) {
			url.append("&showEditable={showEditable}");
		}
		if (count != null) {
			url.append("&count={count}");
		}
		if (start != null) {
			url.append("&start={start}");
		}
		if (sort != null) {
			url.append("&sort={sort}");
		}

		return url.toString();
	}

	
	public Map<String, String> getParameterMap() {
		Map<String, String> uriVariables = new LinkedHashMap<String, String>();

		if (showEditable != false) {
			uriVariables.put("showEditable", "" + showEditable);
		}
		if (count != null) {
			uriVariables.put("count", "" + count);

		}
		if (start != null) {
			uriVariables.put("start", "" + start);
		}
		if (sort != null) {
			uriVariables.put("sort", sort);
		}

		return uriVariables;
	}

}
