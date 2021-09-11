package com.derek;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class Superaxe extends JavaPlugin implements Listener{

    public static final Logger _log = Logger.getLogger("Minecraft");
    public ItemStack superaxe;
    public NamespacedKey key = new NamespacedKey(this, "superaxe");

    @Override
    public void onEnable() {
        Superaxe._log.info("Plugin is enabled!");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Events(getConfig(), this), this);
        Craft();
    }

    @Override
    public void onDisable() {
        Superaxe._log.info("Plugin is disabled!");
    }

    public void Craft() {

        superaxe = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta sAxeMeta = superaxe.getItemMeta();
        List<String> sAxeLore = new ArrayList<>();
        assert sAxeMeta != null;

        sAxeMeta.setDisplayName(ChatColor.RED + "Супер топор");
        sAxeLore.add("Срубает сразу все дерево");
        sAxeMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);

        sAxeMeta.setLore(sAxeLore);
        superaxe.setItemMeta(sAxeMeta);

        ShapedRecipe sAXE = new ShapedRecipe(key, superaxe);

        sAXE.shape("ABA", "BXB", "ABA");

        sAXE.setIngredient('A', Material.NETHERITE_BLOCK);
        sAXE.setIngredient('B', Material.ENCHANTED_BOOK);
        sAXE.setIngredient('X', Material.NETHERITE_AXE);

        getServer().addRecipe(sAXE);
    }
}
