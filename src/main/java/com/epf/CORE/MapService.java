package com.epf.CORE;

import com.epf.CORE.Map;
import java.util.List;
import java.util.Optional;

public interface MapService {

    Map create(Map map);
    Optional<Map> findById(Long id);
    List<Map> findAll();
    Map update(Map map);
    boolean deleteById(Long id);
}
