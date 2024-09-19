package com.example.labee.thirdLab.schemas;


import com.example.labee.model.schemas.XMLDAO;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class AudioFileDAO implements XMLDAO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "audioFile")
    List<AudioFile> audioFileList;
}
