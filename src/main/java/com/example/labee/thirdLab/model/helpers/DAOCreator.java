package com.example.labee.thirdLab.model.helpers;

import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.thirdLab.schemas.AudioFileDAO;

import java.io.File;

public class DAOCreator {
    public static AudioFileDAO createAudiFileDAO(){
        File xmlFile = new File("C:\\Users\\grish\\IdeaProjects\\labEE\\src\\main\\java\\com\\example\\labee\\thirdLab\\resources\\XML\\audioFiles.xml");
        return (AudioFileDAO) XMLParser.deserialize(xmlFile, new AudioFileDAO());
    }
}
