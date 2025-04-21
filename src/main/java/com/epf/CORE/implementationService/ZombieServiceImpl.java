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

    public void create(Zombie zombie) {
        zombieDao.create(zombie);
    }

    public List<Zombie> getAllZombies() {
        return zombieDao.getAllZombies();
    }

    public void update(Zombie zombie) {
        zombieDao.update(zombie);
    }

    public void delete(Zombie zombie) {
        zombieDao.delete(zombie);
    }
}
