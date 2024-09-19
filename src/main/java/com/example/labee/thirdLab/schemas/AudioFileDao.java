package com.example.labee.thirdLab.schemas;

import com.example.labee.model.schemas.XMLDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class AudioFileDao implements XMLDAO {
    List<AudioFile> audioFileList;
}
