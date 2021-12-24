package me.luligabi.indrevnikolite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IndrevNikolite implements ModInitializer {

    @Override
    public void onInitialize() {
        registerBlock("compressed_nikolite_block", COMPRESSED_NIKOLITE_BLOCK);
        registerBlock("nikolite_block", NIKOLITE_BLOCK);

        registerBlock("compressed_enriched_nikolite_block", COMPRESSED_ENRICHED_NIKOLITE_BLOCK);
        registerBlock("enriched_nikolite_block", ENRICHED_NIKOLITE_BLOCK);
    }

    private static final Block COMPRESSED_NIKOLITE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F).requiresTool().sounds(BlockSoundGroup.STONE));
    private static final Block NIKOLITE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F).requiresTool().sounds(BlockSoundGroup.STONE));

    private static final Block COMPRESSED_ENRICHED_NIKOLITE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F).requiresTool().sounds(BlockSoundGroup.STONE));
    private static final Block ENRICHED_NIKOLITE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F).requiresTool().sounds(BlockSoundGroup.STONE));


    private void registerBlock(String identifier, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, identifier), block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, identifier), new BlockItem(block, new FabricItemSettings().group(ITEM_GROUP)));
    }

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
                    new Identifier(IndrevNikolite.MOD_ID, "item_group"))
            .icon(() -> new ItemStack(COMPRESSED_NIKOLITE_BLOCK))
            .build();

    private static final String MOD_ID = "indrev-nikolite";

}