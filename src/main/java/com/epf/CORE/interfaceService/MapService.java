package com.epf.CORE.interfaceService;

import java.util.List;
import com.epf.CORE.models.Map;

public interface MapService {
    Map create(Map map);
    List<Map> getAllMaps();
    Map update(Map map);
    boolean deleteById(Long id);
}
