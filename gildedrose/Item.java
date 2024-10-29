package com.gildedrose;

import java.util.List;
import java.util.ArrayList;


public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public static void main(String args[]) {

        List<Item> items = new ArrayList<>();
        items.add(new Item("Frog", 6, 0));
        items.add(new Item("Axe", 1, 50));
        items.add(new Item("Aged Brie", 9, 10));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 1));
        items.add(new Item("Conjured Sword", 5, 5));

        GildedRose gilda = new GildedRose(items);
        gilda.runInventoryManagement();
        
    }
}



