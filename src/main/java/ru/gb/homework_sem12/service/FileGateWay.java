package ru.gb.homework_sem12.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

// Создадим интерфейс FileGateWay
@MessagingGateway(defaultReplyChannel = "textInputChanel")
public interface FileGateWay {
	void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
