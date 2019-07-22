package com.amazon.domain;

import java.util.List;

public class SummaryOfAllItems {

	private List<Summary> summary;
	private Float grandTotal;

	public List<Summary> getSummary() {
		return summary;
	}

	public void setSummary(List<Summary> summary) {
		this.summary = summary;
	}

	public Float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Float grandTotal) {
		this.grandTotal = grandTotal;
	}

}
