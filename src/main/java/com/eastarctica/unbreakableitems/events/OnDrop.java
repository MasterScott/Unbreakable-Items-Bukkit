package com.eastarctica.unbreakableitems.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Item;
import org.bukkit.inventory.meta.ItemMeta;

public class OnDrop implements Listener {
    Material[] unbreakables = {
            Material.LEATHER_BOOTS, Material.LEATHER_LEGGINGS, Material.LEATHER_CHESTPLATE, Material.LEATHER_HELMET,
            Material.WOODEN_AXE, Material.WOODEN_HOE, Material.WOODEN_PICKAXE, Material.WOODEN_SHOVEL, Material.WOODEN_SWORD,
            Material.STONE_AXE, Material.STONE_HOE, Material.STONE_PICKAXE, Material.STONE_SHOVEL, Material.STONE_SWORD,

            Material.GOLDEN_BOOTS, Material.GOLDEN_LEGGINGS, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_HELMET,
            Material.GOLDEN_AXE, Material.GOLDEN_HOE, Material.GOLDEN_PICKAXE, Material.GOLDEN_SHOVEL, Material.GOLDEN_SWORD,

            Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET,

            Material.IRON_BOOTS, Material.IRON_LEGGINGS, Material.IRON_CHESTPLATE, Material.IRON_HELMET,
            Material.IRON_AXE, Material.IRON_HOE, Material.IRON_PICKAXE, Material.IRON_SHOVEL, Material.IRON_SWORD,

            Material.DIAMOND_BOOTS, Material.DIAMOND_LEGGINGS, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_HELMET,
            Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_PICKAXE, Material.DIAMOND_SHOVEL, Material.DIAMOND_SWORD,

            Material.TURTLE_HELMET, Material.ELYTRA,
            Material.FLINT_AND_STEEL, Material.FISHING_ROD, Material.SHEARS, Material.BOW, Material.CROSSBOW, Material.SHIELD, Material.CARROT_ON_A_STICK
    };

    @EventHandler
    public void OnDrop(PlayerDropItemEvent event) {
        Item droppedItem = event.getItemDrop();
        Material droppedMaterial = droppedItem.getItemStack().getType();
        ItemStack droppedItemStack = droppedItem.getItemStack();

        boolean found = false;
        for(Material unbreakableMaterial : unbreakables) {
            found = droppedMaterial.equals(unbreakableMaterial);
            if (found) {
                ItemMeta craftedItemMeta = droppedItemStack.getItemMeta();
                craftedItemMeta.setUnbreakable(true);
                droppedItemStack.setItemMeta(craftedItemMeta);
                break;
            }
        }
    }
}
