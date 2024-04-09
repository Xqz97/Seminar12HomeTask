package com.example.Seminar12HomeTask.services;


import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Интерфейс FileGateway представляет месседж-шлюз для записи данных в файл.
 *
 * @author Roman Turusov
 */
@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {

    /**
     * Метод writeToFile используется для записи данных в файл.
     *
     * @param filename имя файла для записи данных
     * @param data     данные, которые будут записаны в файл
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}