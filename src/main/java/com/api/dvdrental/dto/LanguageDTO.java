package com.api.dvdrental.dto;

import com.api.dvdrental.entity.language.Language;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@Builder
public class LanguageDTO {

    private Long languageId;
    private String name;
    private LocalDateTime lastUpdate;

    public static LanguageDTO of(Language language){
        return LanguageDTO.builder()
                .languageId(language.getLanguageId())
                .name(language.getName())
                .lastUpdate(language.getLastUpdate())
                .build();
    }

    public static Language of(LanguageDTO languageDTO){
        return Language.builder()
                .languageId(languageDTO.getLanguageId())
                .name(languageDTO.getName())
                .lastUpdate(languageDTO.getLastUpdate())
                .build();
    }

    public static Optional<LanguageDTO> of(Optional<Language> language){
        return language.stream().map(LanguageDTO::of).findAny();
    }

    public static List<LanguageDTO> of(List<Language> languageList){
        return languageList.stream().map(LanguageDTO::of).collect(Collectors.toList());
    }

}