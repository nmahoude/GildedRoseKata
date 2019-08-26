package com.gildedrose.policies.quality;

import com.gildedrose.Item;

class BackstageQualityPolicy implements QualityPolicy {
  @Override
  public void updateItem(Item item) {
    if (item.isSellInDateReached()) {
      item.resetQuality();
      return;
    }
    item.increaseQuality();
    if (item.sellIn < 11) {
      item.increaseQuality();
    }
    if (item.sellIn < 6) {
      item.increaseQuality();
    }
  }
}