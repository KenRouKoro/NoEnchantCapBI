package cn.korostudio.mc.noenchancap.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.server.commands.EnchantCommand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;

@Mixin(EnchantCommand.class)
public class EnchantCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lcom/mojang/brigadier/arguments/IntegerArgumentType;integer(I)Lcom/mojang/brigadier/arguments/IntegerArgumentType;"))
    private static IntegerArgumentType noEnchantCap$anyOnAny(int min) {
        return IntegerArgumentType.integer(Integer.MIN_VALUE);//original.call(Integer.MIN_VALUE);
    }

    @Redirect(method = "enchant", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/Enchantment;getMaxLevel()I"))
    private static int noEnchantCap$uncappedCommand(Enchantment instance) {
        //int max = original.call(enchantment);
        int max = instance.getMaxLevel();
        if (max > 1) {
            return Integer.MAX_VALUE;
        }
        return max;
    }

    @Redirect(method = "enchant", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;isEnchantmentCompatible(Ljava/util/Collection;Lnet/minecraft/world/item/enchantment/Enchantment;)Z"))
    private static boolean noEnchantCap$anyCombination(Collection<Enchantment> existing, Enchantment candidate) {
        return true;
    }

    @Redirect(method = "enchant", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/Enchantment;canEnchant(Lnet/minecraft/world/item/ItemStack;)Z"))
    private static boolean injected(Enchantment instance, ItemStack stack) {
        return true;
    }

   // @WrapOperation(method = "enchant", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/Enchantment;canEnchant(Lnet/minecraft/world/item/ItemStack;)Z"))
    //private static boolean noEnchantCap$canEnchant(Enchantment enchantment, ItemStack stack, Operation<Boolean> original) {
    //    return true;
    //}
}