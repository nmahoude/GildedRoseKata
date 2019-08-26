package com.gildedrose.policies.quality;

import com.gildedrose.Item;

class DoubleDecreaseQualityPolicy implements QualityPolicy {
  @Override
  public void updateItem(Item item) { item.decreaseQuality(); item.decreaseQuality(); }
}