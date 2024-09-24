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

    public void deleteAudioFile(String id) {
        audioFileList.stream().filter(
                audioFile -> audioFile.getId().equals(id)
        ).findFirst().ifPresent(
                audioFile -> audioFileList.remove(audioFile)
        );
    }

    public AudioFile getAudioFile(String id) {
        for (AudioFile audioFile : audioFileList) {
            if (audioFile.getId().equals(id)) {
                return audioFile; // Возвращаем ссылку на найденный объект
            }
        }
        return null; // Если объект не найден, возвращаем null
    }
}
