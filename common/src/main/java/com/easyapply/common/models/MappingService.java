package com.easyapply.common.models;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MappingService {
   @Autowired
    ModelMapper mapper;

    public <T,D> D map(T obj1, Class<D> obj2)
    {
        return (D) mapper.map(obj1, obj2);
    }

}
