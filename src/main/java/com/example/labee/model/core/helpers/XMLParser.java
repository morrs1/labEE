package com.example.labee.model.core.helpers;

import com.example.labee.model.schemas.User;
import com.example.labee.model.schemas.XMLDAO;
import com.example.labee.model.schemas.XMLUsers;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLParser {
    public static XMLDAO deserialize(File xmlFile, XMLDAO xmlDAO) {
        try {
            return new XmlMapper().readValue(xmlFile, XMLUsers.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void serialize(File xmlFile, XMLDAO xmlUsers) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(xmlFile, xmlUsers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void appendUser(File xmlFile, User user) {
        XMLUsers xmlUsers =(XMLUsers) deserialize(xmlFile, new XMLUsers());
        xmlUsers.getUsersList().add(user);
        serialize(xmlFile, xmlUsers);
    }

}
