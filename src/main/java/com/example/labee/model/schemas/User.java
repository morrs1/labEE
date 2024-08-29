package com.example.labee.model.schemas;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class User implements XMLDAO {
    @JacksonXmlProperty(localName = "login")
    private String login;

    @JacksonXmlProperty(localName = "firstName")
    private String firstName;

    @JacksonXmlProperty(localName = "lastName")
    private String lastName;

    @JacksonXmlProperty(localName = "hashedPassword")
    private String hashedPassword;
}
