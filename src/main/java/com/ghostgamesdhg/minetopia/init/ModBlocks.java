package com.ghostgamesdhg.minetopia.init;

import com.ghostgamesdhg.minetopia.MinetopiaExtra;
import com.ghostgamesdhg.minetopia.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MinetopiaExtra.MOD_ID);

    // Blocks place
    public static final RegistryObject<Block> BLUE_CRYSTAL_BLOCK = BLOCKS.register("blue_crystal_block", Blue_Crystal_Block::new);
    public static final RegistryObject<Block> BLUE_CRYSTAL_ORE = BLOCKS.register("blue_crystal_ore", Blue_Crystal_Ore::new);
    public static final RegistryObject<Block> DIAMONDCORE_ORE = BLOCKS.register("diamondcore_ore", diamondcore_ore::new);
    public static final RegistryObject<Block> PIN_AUTOMAAT = BLOCKS.register("pin_automaat", PinAutomaat::new);
    public static final RegistryObject<Block> BLAUWE_KEUKENTEGELS = BLOCKS.register("blauwe_keukentegels", Blauwe_Keukentegels::new);
    public static final RegistryObject<Block> ZWARTE_KEUKENTEGELS = BLOCKS.register("zwarte_keukentegels", Zwarte_Keukentegels::new);
    public static final RegistryObject<Block> BROWN_CABINE = BLOCKS.register("brown_cabine", Brown_Cabine::new);
    public static final RegistryObject<Block> COMPUTER = BLOCKS.register("computer", Computer::new);
    public static final RegistryObject<Block> GREEN_BAG = BLOCKS.register("green_bag", Green_Bag::new);
    public static final RegistryObject<Block> YELLOW_BAG = BLOCKS.register("yellow_bag", Yellow_Bag::new);
    public static final RegistryObject<Block> HONDEN_BEDJE = BLOCKS.register("honden_bedje", Honden_Bedje::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);
    public static final RegistryObject<Block> OIL_CAN = BLOCKS.register("oil_can", Oil_Can::new);
    public static final RegistryObject<Block> PARKING_SIGN = BLOCKS.register("parking_sign", Parking_Sign::new);
    public static final RegistryObject<Block> PRULLENBAK = BLOCKS.register("prullenbak", Prullenbak::new);
    public static final RegistryObject<Block> PUMPKIN = BLOCKS.register("pumpkin", Pumpkin::new);
    public static final RegistryObject<Block> ROADBLOCK = BLOCKS.register("roadblock", Roadblock::new);
    public static final RegistryObject<Block> SCHOENTJE = BLOCKS.register("schoentje", Schoentje::new);
    public static final RegistryObject<Block> TRAFFIC_CONE = BLOCKS.register("traffic_cone", Traffic_Cone::new);
    public static final RegistryObject<Block> VENDING_MACHINE = BLOCKS.register("vending_machine", Vending_Machine::new);
    public static final RegistryObject<Block> LANTAARN = BLOCKS.register("lantaarn", lantaarn::new);
    public static final RegistryObject<Block> BOOMBOX = BLOCKS.register("boombox", boombox::new);
    public static final RegistryObject<Block> MICROFOON = BLOCKS.register("microfoon", microfoon::new);
    public static final RegistryObject<Block> GOPRO = BLOCKS.register("gopro", gopro::new);
    public static final RegistryObject<Block> FILMCAMERA = BLOCKS.register("filmcamera", filmcamera::new);
    public static final RegistryObject<Block> LUCKYBAG = BLOCKS.register("luckybag", luckybag::new);
    public static final RegistryObject<Block> WALKIETALKIE = BLOCKS.register("walkietalkie", walkietalkie::new);
    public static final RegistryObject<Block> KOFFER = BLOCKS.register("koffer", koffer::new);
    public static final RegistryObject<Block> KRANS = BLOCKS.register("krans", krans::new);
    public static final RegistryObject<Block> KERST_SLINGERS = BLOCKS.register("kerst_slingers", kerst_slingers::new);
}
