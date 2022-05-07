package com.digibyte.geofy.item.custom;

import com.digibyte.geofy.util.ModTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;

public class PaxelItem extends DiggerItem implements Vanishable {

    public PaxelItem(Tier pTier, float pAttackDamageModifier,float pAttackSpeedModifier , Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.PAXEL_MINEABLE, pProperties);
    }
}
