package com.example.labee.thirdLab.model.helpers;

import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.thirdLab.schemas.AudioFileDAO;

import java.io.File;


public class DAOCreator {


    public AudioFileDAO createAudiFileDAO() {
        return (AudioFileDAO) XMLParser.deserialize(new File("C:\\Users\\grish\\IdeaProjects\\labEE\\src\\main\\resources\\XML\\audioFiles.xml"), new AudioFileDAO());
    }

    public void serialize(AudioFileDAO audioFileDAO) {
        XMLParser.serialize(new File("C:\\Users\\grish\\IdeaProjects\\labEE\\src\\main\\resources\\XML\\audioFiles.xml"), audioFileDAO);
    }

}
