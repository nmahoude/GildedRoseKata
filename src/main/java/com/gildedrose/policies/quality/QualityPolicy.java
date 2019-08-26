package com.gildedrose.policies.quality;

import com.gildedrose.Item;

@FunctionalInterface
public interface QualityPolicy {
  public void updateItem(Item item);
}
