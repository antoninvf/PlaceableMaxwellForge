package com.antoninvf.placeablemaxwell.blocks;

import com.antoninvf.placeablemaxwell.PlaceableMaxwell;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MaxwellBlock extends FallingBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public MaxwellBlock(Block.Properties properties) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        world.addParticle(ParticleTypes.HEART, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 0, 0.5, 0);
        if (!world.isClientSide()) {
            world.playSound(null, pos, SoundEvents.CAT_AMBIENT, SoundSource.BLOCKS, 1, new Random().nextFloat() * (1.2f - 0.8f) + 0.8f);
        }

        // if player is holding any type of fish
       /*if (player.getItemInHand(hand).is(ItemTags.FISHES)) {
            world.destroyBlock(pos, true);
            return InteractionResult.CONSUME;
        }*/

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onLand(Level world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if (!world.isClientSide()) {
            world.playSound(null, pos, SoundEvents.CAT_AMBIENT, SoundSource.BLOCKS, 1, new Random().nextFloat() * (1.2f - 0.8f) + 0.8f);
        }
    }

    @Override
    public @NotNull DamageSource getFallDamageSource() {
        return new DamageSource(PlaceableMaxwell.MOD_ID + ".falling_maxwell_cat").damageHelmet();
    }

    // Does 20 damage to the player when Maxwell falls on them
    @Override
    protected void falling(FallingBlockEntity fallingBlockEntity) {
        fallingBlockEntity.setHurtsEntities(20,20);
    }

    // adds all the block state properties you want to use
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // gets the correct block state for the player to place
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }
}
