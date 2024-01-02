package net.cass.blahaj.block;

import net.cass.blahaj.Blahaj;
import net.cass.blahaj.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class ModBlocks extends Block{
    public ModBlocks(Settings settings){
        super(settings);
    }
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final Block BLAHAJ = registerBlock("blahaj", new ModBlocks(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_WOOL).nonOpaque()));
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

    @Nullable
    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(FACING);
    }
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation){
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror){
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx){
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().rotateClockwise(Direction.Axis.Y));
    }

}
