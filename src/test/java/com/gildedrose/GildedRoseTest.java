package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void shouldUseItemsInParameters() {
    Item[] items = new Item[] { new Item("foo", 0, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items.get(0).name);
  }

  @Test
  public void stringRepresentation() throws Exception {
    Item standard = new Item("foo", 10, 20);

    assertThat(standard.toString()).isEqualTo("foo, 10, 20");
  }
  
  @Test
  public void sellInDecreaseWhenItemUpdated() throws Exception {
    Item standard = new Item("foo", 10, 20);
    GildedRose app = new GildedRose(new Item[] { standard });
    app.updateQuality();

    assertThat(standard.sellIn).isEqualTo(9);
  }

  @Test
  public void standardItem_shouldDecreaseQualityByOne() throws Exception {
    Item standard = new Item("foo", 10, 20);
    GildedRose app = new GildedRose(new Item[] { standard });
    app.updateQuality();

    assertThat(standard.quality).isEqualTo(19);
  }

  @Test
  public void standardItem_shouldNotDecreaseAt0() throws Exception {
    Item standard = new Item("foo", 10, 0);
    GildedRose app = new GildedRose(new Item[] { standard });
    app.updateQuality();

    assertThat(standard.quality).isEqualTo(0);
  }

  @Test
  public void standardItem_shouldDecreaseBy2IfSellInReached() throws Exception {
    Item standard = new Item("foo", 0, 20);
    GildedRose app = new GildedRose(new Item[] { standard });
    app.updateQuality();

    assertThat(standard.quality).isEqualTo(18);
  }

  @Test
  public void agedBrieIncreaseQualityWithTime() throws Exception {
    Item agedBrie = new Item(Item.AGED_BRIE, 5, 10);
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();

    assertThat(agedBrie.quality).isEqualTo(10 + 1);
  }

  @Test
  public void agedBrieCantIncreaseOver50() throws Exception {
    Item agedBrie = new Item(Item.AGED_BRIE, 5, 50);
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();

    assertThat(agedBrie.quality).isEqualTo(50 + 0);
  }

  @Test
  public void sulfuras_hasNoSellInDate() throws Exception {
    Item sulfuras = new Item(Item.SULFURAS, 5, 50);
    GildedRose app = new GildedRose(new Item[] { sulfuras });
    app.updateQuality();

    assertThat(sulfuras.sellIn).isEqualTo(5);
  }

  @Test
  public void sulfuras_hasConstantQuality() throws Exception {
    Item sulfuras = new Item(Item.SULFURAS, 10, 15);
    GildedRose app = new GildedRose(new Item[] { sulfuras });
    app.updateQuality();

    assertThat(sulfuras.quality).isEqualTo(15);
  }

  @Test
  public void backstage_increaseQualityWithTime_1whenOver10Days() throws Exception {
    Item backstage = new Item(Item.BACKSTAGE, 30, 15);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();

    assertThat(backstage.quality).isEqualTo(15 + 1);
  }

  @Test
  public void backstage_increaseQualityWithTime_2whenOver5Days() throws Exception {
    Item backstage = new Item(Item.BACKSTAGE, 10, 20);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();

    assertThat(backstage.quality).isEqualTo(20 + 2);
  }

  @Test
  public void backstage_increaseQualityWithTime_3whenLessThan5days() throws Exception {
    Item backstage = new Item(Item.BACKSTAGE, 4, 7);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();

    assertThat(backstage.quality).isEqualTo(7 + 3);
  }

  @Test
  public void backstage_shouldBe0WhenSellInExceded() throws Exception {
    Item backstage = new Item(Item.BACKSTAGE, 0, 15);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();

    assertThat(backstage.quality).isEqualTo(0);
  }

  @Test
  public void conjured_degrades2TimesFaster() throws Exception {
    Item conjured = new Item(Item.CONJURED, 10, 20);

    GildedRose app = new GildedRose(new Item[] { conjured });
    app.updateQuality();

    assertThat(conjured.quality).isEqualTo(18);
  }
}
