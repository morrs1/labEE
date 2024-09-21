package com.example.labee.thirdLab.schemas;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AudioFile {
    @JacksonXmlProperty(localName = "id")
    private String id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "artist")
    private String artist;
    @JacksonXmlProperty(localName = "genre")
    private String genre;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, artist: %s, genre: %s", id, name, artist, genre);
    }
}
