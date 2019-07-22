package com.amazon.service.item;

import java.util.ArrayList;
import java.util.List;

import com.amazon.domain.Item;

public class ItemService {

	public List<Item> getItems() {

		List<Item> items = new ArrayList<>();

		items.add(new Item(1, "Chair", 45.58f, "Wooden chair",0));
		items.add(new Item(2, "Table", 9.5f, "Steel table",0));
		items.add(new Item(3, "Lamp", 6.00f, "Yellow lamp",0));
		return items;
	}

}
