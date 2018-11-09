import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
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