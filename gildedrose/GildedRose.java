package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQualityItems() {
        // Itera su ogni articolo nella lista degli articoli
        for (Item item : items) {
            // Controlla se l'articolo è "Aged Brie" e nel caso aggiorna la qualità
            if (item.name.equals("Aged Brie")) {
                updateBrie(item);
            // Controlla se l'articolo è "Backstage passes" e nel caso aggiorna la qualità
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstage(item);
            // Controlla se l'articolo è un "Conjured item" e nel caso aggiorna la qualità
            } else if (item.name.contains("Conjured")) {
                updateConjuredItem(item);
            // Gestisce gli articoli di tipo base che non sono "Sulfuras" e nel caso aggiorna la qualità
            } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateBasicItem(item);
            }
        }
    }

    
    
    public void updateBasicItem(Item item) {
        // Riduci il sellIn di 1
        item.sellIn--;
        // Diminuisci la qualità, 2 se scaduto, altrimenti 1
        if (item.quality > 0) {
            item.quality -= (item.sellIn < 0) ? 2 : 1;
        }
    }

    // public void updateQuality() {
    //     for (int i = 0; i < items.length; i++) {
    //         if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    //             if (items[i].quality > 0) {
    //                 if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    //                     items[i].quality = items[i].quality - 1;
    //                 }
    //             }
    //         } else {
    //             if (items[i].quality < 50) {
    //                 items[i].quality = items[i].quality + 1;

    //                 if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    //                     if (items[i].sellIn < 11) {
    //                         if (items[i].quality < 50) {
    //                             items[i].quality = items[i].quality + 1;
    //                         }
    //                     }

    //                     if (items[i].sellIn < 6) {
    //                         if (items[i].quality < 50) {
    //                             items[i].quality = items[i].quality + 1;
    //                         }
    //                     }
    //                 }
    //             }
    //         }

    //         if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    //             items[i].sellIn = items[i].sellIn - 1;
    //         }

    //         if (items[i].sellIn < 0) {
    //             if (!items[i].name.equals("Aged Brie")) {
    //                 if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    //                     if (items[i].quality > 0) {
    //                         if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    //                             items[i].quality = items[i].quality - 1;
    //                         }
    //                     }
    //                 } else {
    //                     items[i].quality = items[i].quality - items[i].quality;
    //                 }
    //             } else {
    //                 if (items[i].quality < 50) {
    //                     items[i].quality = items[i].quality + 1;
    //                 }
    //             }
    //         }
    //     }
    // }
}