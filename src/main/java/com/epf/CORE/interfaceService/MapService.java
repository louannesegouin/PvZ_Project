package com.epf.CORE.interfaceService;

import java.util.List;
import java.util.Optional;

import com.epf.CORE.models.Map;

public interface MapService {

    Map create(Map map);
    Optional<Map> findById(Long id);
    List<Map> findAll();
    Map update(Map map);
    boolean deleteById(Long id);
}
