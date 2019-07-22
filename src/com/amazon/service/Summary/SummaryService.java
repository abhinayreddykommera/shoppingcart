package com.amazon.service.Summary;

import java.util.ArrayList;
import java.util.List;

import com.amazon.domain.Item;
import com.amazon.domain.Summary;
import com.amazon.domain.SummaryOfAllItems;

public class SummaryService {

	public SummaryOfAllItems getSummary(List<Item> cart){
		SummaryOfAllItems summaryOfAllItems=new SummaryOfAllItems();
		List<Summary> lstSummary=new ArrayList<>();
		summaryOfAllItems.setSummary(lstSummary);
		Float grandTotal=0.0f;
		
		for(Item item:cart){
			String name=item.getName();
			Integer quantity=item.getQuantity();
			Float unitPrice=item.getUnitPrice();
			Float totalPrice=quantity*unitPrice;
			grandTotal+=totalPrice;
			Summary summary=new Summary(name,quantity,totalPrice);
			lstSummary.add(summary);
		}
		summaryOfAllItems.setGrandTotal(grandTotal);
		return summaryOfAllItems;
		
	}
	
}
