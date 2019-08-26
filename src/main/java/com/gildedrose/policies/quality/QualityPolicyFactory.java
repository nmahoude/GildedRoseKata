package com.gildedrose.policies.quality;

import com.gildedrose.Item;

public class QualityPolicyFactory {

  private QualityPolicyFactory() {
  }
  public static QualityPolicy getForItemName(String name) {
    switch (name) {
    case Item.CONJURED:
      return new DoubleDecreaseQualityPolicy();
    case Item.AGED_BRIE:
      return new SimpleIncreaseQualityPolicy();
    case Item.BACKSTAGE:
      return new BackstageQualityPolicy();
    case Item.SULFURAS:
      return new ConstantQualityPolicy();
    default:
      return new StandardQualityPolicy();
    }
  }
}
