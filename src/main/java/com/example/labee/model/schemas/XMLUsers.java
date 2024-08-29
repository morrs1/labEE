package com.example.labee.model.schemas;

import com.example.labee.model.core.helpers.XMLParser;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.io.File;
import java.util.List;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class XMLUsers implements XMLDAO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "user")
    private List<User> usersList;

    public User getByLogin(String login) {
        return usersList.stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }
}
