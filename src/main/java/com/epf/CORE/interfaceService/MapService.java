package com.epf.CORE.interfaceService;

import java.util.List;
import com.epf.CORE.models.Map;

public interface MapService {
    void create(Map map);
    List<Map> getAllMaps();
    void update(Map map);
    void delete(Map map);
}
