package com.example.labee.model.core;

import com.example.labee.model.schemas.XMLDAO;
import com.example.labee.model.schemas.XMLRootUsers;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLParser {
    public static XMLDAO parseXML(File xmlFile, XMLDAO xmlDAO) {
        try {
            return new XmlMapper().readValue(xmlFile, xmlDAO.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
