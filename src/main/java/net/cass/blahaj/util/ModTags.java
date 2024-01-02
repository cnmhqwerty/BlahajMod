package net.cass.blahaj.util;

import net.cass.blahaj.Blahaj;
import net.minecraft.block.Block;
import net.minecraft.client.gui.tab.Tab;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags
{
    public static class Blocks{
        public static final TagKey<Block> PLUSHIES =
                createTag("plushies");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Blahaj.MOD_ID, name));
        }
    }

    public static class Items{
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Blahaj.MOD_ID, name));
        }
    }
}
