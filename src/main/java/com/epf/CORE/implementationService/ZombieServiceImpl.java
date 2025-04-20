package com.epf.CORE.implementationService;

import com.epf.CORE.models.Zombie;
import com.epf.PERSISTANCE.InterfaceDAO.ZombieDao;
import com.epf.CORE.interfaceService.ZombieService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZombieServiceImpl implements ZombieService {

    private final ZombieDao zombieDao;

    public ZombieServiceImpl(ZombieDao zombieDao) {
        this.zombieDao = zombieDao;
    }

    @Override
    public Zombie create(Zombie zombie) {
        return zombieDao.create(zombie);
    }

    @Override
    public List<Zombie> getAllZombies() {
        return zombieDao.getAllZombies();
    }

    @Override
    public Zombie update(Zombie zombie) {
        return zombieDao.update(zombie);
    }

    @Override
    public boolean deleteById(Long id) {
        return zombieDao.deleteById(id);
    }
}
