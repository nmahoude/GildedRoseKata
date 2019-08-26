package com.gildedrose.policies.quality;

import com.gildedrose.Item;

public class ConstantQualityPolicy implements QualityPolicy {

  @Override
  public void updateItem(Item item) {
    // constant quality, nothing to do 
  }

}
