package com.gildedrose;

public class Item {
  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
  public static final String CONJURED = "Conjured";
  
  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  public void decreaseQuality() {
    if (quality > 0) {
      quality = quality - 1;
    }
  }

  public void increaseQuality() {
    if (quality < 50) {
      quality = quality + 1;
    }
  }

  public void resetQuality() {
    quality = 0;
  }

  public boolean isSellInDateReached() {
    return sellIn < 0;
  }
}
