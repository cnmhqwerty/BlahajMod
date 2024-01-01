package net.cass.blahaj.block;

import net.cass.blahaj.Blahaj;
import net.cass.blahaj.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModBlocks{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final Block BLAHAJ = registerBlock("blahaj", new Block(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_WOOL)));
    private static void addBlocksToColourItemGroup(FabricItemGroupEntries entries){entries.add(BLAHAJ);}

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, new Identifier(Blahaj.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Blahaj.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(ModBlocks::addBlocksToColourItemGroup);
            Blahaj.LOGGER.info("Registering Mod Blocks for " + Blahaj.MOD_ID);
    }
}
