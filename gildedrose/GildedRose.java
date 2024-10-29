package com.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }


    public void runInventoryManagement() {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("---- Inventario ----");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println("-------------------");

            // Aggiornamento qualità degli items
            updateQualityItems();

            // Permette di andare avanti di un giorno
            System.out.print("Vuoi andare avanti di un giorno? (y/n): ");
            String continueInput = scanner.nextLine();
            keepGoing = continueInput.equalsIgnoreCase("y");

            // Permette di aggiungere un nuovo oggetto
            System.out.print("Vuoi aggiungere un nuovo oggetto? (y/n): ");
            String addItemInput = scanner.nextLine();
            if (addItemInput.equalsIgnoreCase("y")) {
                addItem(scanner);
            }
        }
        scanner.close();
    }

    private void addItem(Scanner scanner) {
        // Inserisce il nome del nuovo item
        System.out.print("Inserisci il nome dell'oggetto: ");
        String name = scanner.nextLine();

        // Inserisce il sellIn del nuovo item
        System.out.print("Inserisci il valore SellIn: ");
        int sellIn = Integer.parseInt(scanner.nextLine());

        // Inserisce la quality del nuovo item
        System.out.print("Inserisci il valore Quality: ");
        int quality = Integer.parseInt(scanner.nextLine());

        // aggiunge il nuovo item all'inventario
        items.add(new Item(name, sellIn, quality));
        System.out.println("Oggetto aggiunto: " + name + ", " + sellIn + ", " + quality);
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

    public void updateQualityItems() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                updateBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstage(item);
            } else if (item.name.contains("Conjured")) {
                updateConjuredItem(item);
            } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateBasicItem(item);
            }
        }
    }


    public void updateBackstage(Item item){
        if (item.sellIn == 0) {
            item.quality = 0;
        } else {
            if (item.sellIn < 6) {
                item.quality += 3;
            } else if (item.sellIn < 11) {
                item.quality += 2;
            } else {
                item.quality++;
            }

            if (item.quality > 50) {
                item.quality = 50;
            }
        }
        item.sellIn--;
    }

    public void updateBrie(Item item){
        item.sellIn--;
        if(item.quality<50){
            item.quality++;
        }
    }

    public void updateConjuredItem(Item item){
        item.sellIn--;
        item.quality -= (item.sellIn < 0) ? 4 : 2;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    public void updateBasicItem(Item item){
        item.sellIn--;
        if (item.quality > 0) {
            item.quality -= (item.sellIn < 0) ? 2 : 1;
        }
    }

    
}