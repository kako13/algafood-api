package com.algaworks.algafood.core;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomRestFilter {

    public MappingJacksonValue wrapFilter(String filterName, String fields, List<?> modelsList) {

        MappingJacksonValue modelWrapper = new MappingJacksonValue(modelsList);

        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter(filterName, SimpleBeanPropertyFilter.serializeAll());

        if (StringUtils.isNotBlank(fields)) {
            Set<String> setCampos = Arrays.stream(fields.split(",")).map(String::trim).collect(Collectors.toSet());
            filterProvider.addFilter(filterName, SimpleBeanPropertyFilter.filterOutAllExcept(setCampos));
        }
        modelWrapper.setFilters(filterProvider);
        return  modelWrapper;
    }
}
