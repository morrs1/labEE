package com.example.labee.model.schemas;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class User implements XMLDAO {
    @JacksonXmlProperty(localName = "login")
    private String login;

    @JacksonXmlProperty(localName = "hashedPassword")
    private String hashedPassword;
}
