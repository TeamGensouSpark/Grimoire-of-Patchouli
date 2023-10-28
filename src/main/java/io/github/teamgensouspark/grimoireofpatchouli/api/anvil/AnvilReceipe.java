package io.github.teamgensouspark.grimoireofpatchouli.api.anvil;

import java.util.function.Predicate;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;

public class AnvilReceipe {
    public int cost = 10;
    public boolean isShape = false;
    public ItemStack result = ItemStack.EMPTY;
    public Predicate<ItemStack> left;
    public Predicate<ItemStack> right;

    public AnvilReceipe(Predicate<ItemStack> left, Predicate<ItemStack> right) {
        this.left = left;
        this.right = right;
    }

    public AnvilReceipe() {
    }

    public AnvilReceipe setLeft(Predicate<ItemStack> left) {
        this.left = left;
        return this;
    }

    public AnvilReceipe setRight(Predicate<ItemStack> right) {
        this.right = right;
        return this;
    }

    public AnvilReceipe setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public AnvilReceipe setShape(boolean isShape) {
        this.isShape = isShape;
        return this;
    }

    public AnvilReceipe setResult(ItemStack itemStack) {
        this.result = itemStack;
        return this;
    }

    public boolean match(ItemStack left, ItemStack right) {
        return isShape ? this.left.test(left) && this.right.test(right)
                : this.left.test(left) && this.right.test(right) || this.left.test(right) && this.right.test(left);
    }

    public boolean matchThen(ItemStack left, ItemStack right, Runnable F) {
        if (match(left, right)) {
            F.run();
            return true;
        }
        return false;
    }

    public void apply(AnvilUpdateEvent event) {
        ItemStack result = this.result.copy();
        if (result != ItemStack.EMPTY && result != null) {
            event.setOutput(result);
            event.setCost(cost);
        }
    }

}
