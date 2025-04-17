package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import java.util.Optional;

import com.epf.CORE.models.Map;

public interface MapDao {
    Map create(Map gameMap);
    Optional<Map> findById(Long id);
    List<Map> findAll();
    Map update(Map gameMap);
    boolean deleteById(Long id);
}
