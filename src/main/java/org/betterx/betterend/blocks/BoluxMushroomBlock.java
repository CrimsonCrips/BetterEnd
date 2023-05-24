package org.betterx.betterend.blocks;

import org.betterx.bclib.behaviours.BehaviourBuilders;
import org.betterx.betterend.blocks.basis.EndPlantBlock;
import org.betterx.betterend.registry.EndBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import com.google.common.collect.Lists;

import java.util.List;

public class BoluxMushroomBlock extends EndPlantBlock {
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 9, 15);

    public BoluxMushroomBlock() {
        super(BehaviourBuilders.createPlant().lightLevel((bs)->10));
    }

    @Override
    protected boolean isTerrain(BlockState state) {
        return state.is(EndBlocks.RUTISCUS);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
        return SHAPE;
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        return Lists.newArrayList(new ItemStack(this));
    }
}
