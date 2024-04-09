package com.example.Seminar12HomeTask.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * Конфигурация интеграции для обработки сообщений и записи в файл.
 * @author Roman Turusov
 */
@Configuration
public class IntegrationConfig {

    /**
     * Создание канала для приема текстовых сообщений.
     *
     * @return Канал для текстовых сообщений
     */
    @Bean
    public MessageChannel textInputChannel() {
        return new DirectChannel();
    }

    /**
     * Создание канала для записи в файл.
     *
     * @return Канал для записи в файл
     */
    @Bean
    public MessageChannel fileWriterChannel() {
        return new DirectChannel();
    }

    /**
     * Главный трансформер для преобразования текстовых сообщений.
     *
     * @return Трансформер для преобразования текста
     */
    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> text;
    }

    /**
     * Обработчик сообщений для записи в файл.
     *
     * @return Обработчик для записи в файл
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("D:/Turusov.RA/Work/Учеба/Java/Geekbrains/Specialization/SpringSeminarAndLection/Seminar12/Seminar12HomeTask/src/main/java/com/example/Seminar12HomeTask/files/"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}