// Ваш пакет, имя и версия мода
package com.example.mygraphicalmod;

// Импортируем необходимые классы из Forge
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

// Аннотация для объявления мода
@Mod(modid = MyGraphicalMod.MODID, version = MyGraphicalMod.VERSION)
public class MyGraphicalMod
{
    // ID и версия мода
    public static final String MODID = "mygraphicalmod";
    public static final String VERSION = "1.0";

    // Обработчик события инициализации мода
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Регистрируем этот класс как обработчик событий
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Метод для изменения цвета текста в чате
    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent event)
    {
        // Проверяем, является ли полученное сообщение обычным сообщением чата (не системным)
        if (!event.isCanceled() && event.getType() == 0)
        {
            // Получаем текст сообщения
            String message = event.getMessage().getUnformattedText();

            // Изменяем цвет текста на зеленый
            String newMessage = "§a" + message;

            // Создаем новый объект текста с измененным сообщением
            TextComponentString newText = new TextComponentString(newMessage);

            // Заменяем оригинальное сообщение на новый текст
            event.setMessage(newText);
        }
    }
}
