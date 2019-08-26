package com.gildedrose.policies.sellin;

import com.gildedrose.Item;

public class SellinPolicyFactory {

  private SellinPolicyFactory() {
  }
  public static SellinPolicy getForItemName(String name) {
    if (Item.SULFURAS.equals(name)) {
      return (Item item) -> {};
    } else {
      return (Item item) -> { item.sellIn--; };
    }
  }
}
