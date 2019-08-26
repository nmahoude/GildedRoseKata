package com.gildedrose.policies.quality;

import com.gildedrose.Item;

final class StandardQualityPolicy implements QualityPolicy {
  @Override
  public void updateItem(Item item) { 
    item.decreaseQuality(); 
    if (item.isSellInDateReached()) {
      item.decreaseQuality();
    }
  }
}