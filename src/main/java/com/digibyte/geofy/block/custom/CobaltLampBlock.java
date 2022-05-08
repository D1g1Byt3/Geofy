package com.digibyte.geofy.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class CobaltLampBlock  extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public CobaltLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
    }



    @Override
    public @NotNull InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                          Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND){
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }
}
