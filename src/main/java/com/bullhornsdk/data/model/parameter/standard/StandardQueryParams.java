package com.bullhornsdk.data.model.parameter.standard;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bullhornsdk.data.model.parameter.QueryParams;

public class StandardQueryParams implements QueryParams {

	private boolean showEditable;

	private Integer count;

	private Integer start;

	private String orderBy;

	private boolean showTotalMatched;

	private boolean useDefaultQueryFilter;

	private StandardQueryParams() {
		super();

		this.showEditable = false;
		this.count = 20;
		this.start = null;
		this.orderBy = null;
		this.showTotalMatched = true;
		this.useDefaultQueryFilter = true;
	}

	public static StandardQueryParams getInstance() {
		StandardQueryParams params = new StandardQueryParams();

		return params;
	}

	public void setShowEditable(boolean showEditable) {
		this.showEditable = showEditable;

	}

	
	public Integer getCount() {
		return count;
	}

	/**
	 * Limit on the number of entities to return. Default is 20.
	 * 
	 * @param count
	 */

	
	public void setCount(Integer count) {
		this.count = count;
	}

	
	public Integer getStart() {
		return start;
	}

	
	public void setStart(Integer start) {
		this.start = start;
	}

	
	public String getOrderBy() {
		return orderBy;
	}

	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	
	public void setShowTotalMatched(boolean showTotalMatched) {
		this.showTotalMatched = showTotalMatched;
	}

	
	public Boolean getUseDefaultQueryFilter() {
		return useDefaultQueryFilter;
	}

	
	public void setUseDefaultQueryFilter(boolean useDefaultQueryFilter) {
		this.useDefaultQueryFilter = useDefaultQueryFilter;
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
		if (orderBy != null) {
			url.append("&orderBy={orderBy}");
		}
		if (showTotalMatched != false) {
			url.append("&showTotalMatched={showTotalMatched}");
		}
		if (useDefaultQueryFilter != true) {
			url.append("&useDefaultQueryFilter={useDefaultQueryFilter}");
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
		if (orderBy != null) {
			uriVariables.put("orderBy", orderBy);
		}

		if (showTotalMatched != false) {
			uriVariables.put("showTotalMatched", "" + showTotalMatched);
		}

		if (useDefaultQueryFilter != true) {
			uriVariables.put("useDefaultQueryFilter", "" + useDefaultQueryFilter);
		}

		return uriVariables;
	}

}
