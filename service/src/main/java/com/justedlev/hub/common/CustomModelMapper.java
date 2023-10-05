package com.justedlev.hub.common;

import com.github.justedlev.modelmapper.BaseModelMapper;
import com.github.justedlev.modelmapper.converter.date.LocalDate2Timestamp;
import com.github.justedlev.modelmapper.converter.date.LocalDateTime2Timestamp;
import com.github.justedlev.modelmapper.converter.date.Timestamp2LocalDate;
import com.github.justedlev.modelmapper.converter.date.Timestamp2LocalDateTime;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

@Component
public class CustomModelMapper extends BaseModelMapper {
    public CustomModelMapper() {
        addConverters(getConverters());
    }

    private Set<Converter<? extends Serializable, ?>> getConverters() {
        return Set.of(
                LocalDateTime2Timestamp.getInstance(),
                Timestamp2LocalDateTime.getInstance(),
                LocalDate2Timestamp.getInstance(),
                Timestamp2LocalDate.getInstance()
        );
    }
}
