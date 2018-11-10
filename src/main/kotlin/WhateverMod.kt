import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

const val MODID = "whatever_mod"
const val NAME = "Whatever Mod"
const val VERSION = "0.1"

val logger: Logger = LogManager.getLogger(MODID)

@Mod(modid=MODID, name=NAME, version=VERSION, modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object WhateverMod{
    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent){
        logger.info("Pre init fired for ${event.side}")
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent){
        logger.info("Init fired for ${event.side}")
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent){
        logger.info("Post init fired for ${event.side}")
    }
}

@Mod.EventBusSubscriber(modid=MODID)
object EventHandler{
    @JvmStatic
    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>){
        event.registry.register(TutorialItem)
    }

    @JvmStatic
    @SubscribeEvent
    fun registerModels(event: ModelRegistryEvent){
        ModelLoader.setCustomModelResourceLocation(TutorialItem, 0, ModelResourceLocation(TutorialItem.registryName ?: return, "inventory"))
    }
}

object TutorialItem : Item(){
    init{
        this.registryName = ResourceLocation(MODID, "tutorial_item")
        this.unlocalizedName = "tutorial_item"
        this.creativeTab = CreativeTabs.MISC
    }

    override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
        playerIn.sendStatusMessage(TextComponentString("What's up it works yeahhhh"), true)
        return ActionResult.newResult(EnumActionResult.SUCCESS, ItemStack(this))
    }
}