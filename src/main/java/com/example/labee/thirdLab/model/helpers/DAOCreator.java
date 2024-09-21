package com.example.labee.thirdLab.model.helpers;

import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.thirdLab.schemas.AudioFileDAO;

import java.io.InputStream;

public class DAOCreator {


    public AudioFileDAO createAudiFileDAO() {
        InputStream streamOfAudioFile = DAOCreator.class.getClassLoader().getResourceAsStream("XML/audioFiles.xml");
        if (streamOfAudioFile == null) {
            throw new RuntimeException("Файл не найден: XML/audioFiles.xml");
        }
        return (AudioFileDAO) XMLParser.deserialize(streamOfAudioFile, new AudioFileDAO());
    }

}
