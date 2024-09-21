package com.example.labee.thirdLab.model.helpers;

import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.thirdLab.schemas.AudioFileDAO;
import lombok.Getter;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DAOCreator {


    public static AudioFileDAO createAudiFileDAO() {
        InputStream streamOfAudioFile = DAOCreator.class.getClassLoader().getResourceAsStream("XML/audioFiles.xml");
        if (streamOfAudioFile == null) {
            throw new RuntimeException("Файл не найден: XML/audioFiles.xml");
        }
        return (AudioFileDAO) XMLParser.deserialize(streamOfAudioFile, new AudioFileDAO());
    }

    public static FileOutputStream getOutputStream() throws IOException {
        return new FileOutputStream("src/main/resources/XML/audioFiles.xml");
    }
}
