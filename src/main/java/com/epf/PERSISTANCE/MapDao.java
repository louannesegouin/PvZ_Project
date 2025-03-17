package com.epf.PERSISTANCE;

import com.epf.CORE.Map; // ou GameMap
import java.util.List;
import java.util.Optional;

public interface MapDao {
    Map create(Map gameMap);
    Optional<Map> findById(Long id);
    List<Map> findAll();
    Map update(Map gameMap);
    boolean deleteById(Long id);
}
