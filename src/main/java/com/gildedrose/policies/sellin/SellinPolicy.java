package com.gildedrose.policies.sellin;

import com.gildedrose.Item;

@FunctionalInterface
public interface SellinPolicy {
  public void updateItem(Item item);
}
