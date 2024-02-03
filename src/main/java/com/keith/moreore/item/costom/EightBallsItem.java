package com.keith.moreore.item.costom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallsItem extends Item {
    public EightBallsItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient && hand == Hand.MAIN_HAND) {

        }
        OutPutRandomNumber(user);
        user.getItemCooldownManager().set(this,30);
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Right click and get a random number!")
                    .formatted(Formatting.AQUA));
        } else{
            tooltip.add(Text.literal("Press shift for more information!").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void OutPutRandomNumber(PlayerEntity player) {
        player.sendMessage(Text.literal("Your number is " + getRandomNumber()));
    }
    private int getRandomNumber() {
        return Random.create().nextInt(10);
    }
}
