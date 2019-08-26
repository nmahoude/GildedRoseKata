package com.gildedrose.policies;

import com.gildedrose.Item;
import com.gildedrose.policies.quality.QualityPolicy;
import com.gildedrose.policies.quality.QualityPolicyFactory;
import com.gildedrose.policies.sellin.SellinPolicy;
import com.gildedrose.policies.sellin.SellinPolicyFactory;

public class GildedRoseItemPolicy {
  public static GildedRoseItemPolicy getFromItemName(String name) {
    SellinPolicy sellinPolicy = SellinPolicyFactory.getForItemName(name);
    QualityPolicy qualityPolicy = QualityPolicyFactory.getForItemName(name);
    
    return new GildedRoseItemPolicy(qualityPolicy, sellinPolicy);
  }
  
  QualityPolicy qualityPolicy;
  SellinPolicy sellinPolicy;

  private GildedRoseItemPolicy(QualityPolicy qualityPolicy, SellinPolicy sellinPolicy) {
    super();
    this.qualityPolicy = qualityPolicy;
    this.sellinPolicy = sellinPolicy;
  }


  public void update(Item item) {
    sellinPolicy.updateItem(item);
    qualityPolicy.updateItem(item);
  }
}
