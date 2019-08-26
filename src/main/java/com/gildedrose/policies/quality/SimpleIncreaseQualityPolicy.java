package com.gildedrose.policies.quality;

import com.gildedrose.Item;

class SimpleIncreaseQualityPolicy implements QualityPolicy {
  @Override
  public void updateItem(Item item) { item.increaseQuality();}
}