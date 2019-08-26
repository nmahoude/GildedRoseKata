package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

import com.gildedrose.policies.GildedRoseItemPolicy;

class GildedRose {

  List<Item> items = new ArrayList<>();

  public GildedRose(Item[] items) {
    this.items = List.of(items);
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItem(item);
    }
  }

  private void updateItem(Item item) {
    GildedRoseItemPolicy policy = GildedRoseItemPolicy.getFromItemName(item.name);
    policy.update(item);
  }
}