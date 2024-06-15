package ru.gb.homework_sem12.config;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

// создаем директорию configuration и файл IntegrationConfig 
// будут созданы четыре бина, они будут положенны в иок контейнер, 
// интегрейшен увидит свои бины, и выложит цепочьку действий
@Configuration
public class IntegrationConfig {

	@Bean
	public MessageChannel textInputChanel(){
		return new DirectChannel();
	}

	@Bean
	public MessageChannel fileWriterChanel(){
		return new DirectChannel();
	}

	@Bean
	@Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
	public GenericTransformer<String, String> myTransformer(){
		return text -> {
			return text.toLowerCase().trim();};	// Здесь производим любое преобразование текста
		// return text -> text.toLowerCase().trim();
	}

	@Bean
	@ServiceActivator(inputChannel = "fileWriterChanel")
	public FileWritingMessageHandler meMessagehandler(){
		FileWritingMessageHandler handler = 
			new FileWritingMessageHandler(new File("F:\\Учеба\\Новая папка (6)\\Семинар\\15. Фреймворк Spring (семинары)\\Урок 12. Паттерны проектирония и GoF паттерны в Spring приложении\\homework_sem12"));
		handler.setExpectReply(false);
		handler.setFileExistsMode(FileExistsMode.APPEND);
		handler.setAppendNewLine(true);
		return handler;
	}
}
