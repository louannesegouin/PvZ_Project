package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import com.epf.CORE.models.Map;

public interface MapDao {
    void create(Map map);
    List<Map> getAllMaps();
    void update(Map map);
    void delete(Map map);
}
