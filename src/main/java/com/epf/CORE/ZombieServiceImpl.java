package com.epf.CORE;

import com.epf.PERSISTANCE.ZombieDao;
import com.epf.CORE.Zombie;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public Optional<Zombie> findById(Long id) {
        return zombieDao.findById(id);
    }

    @Override
    public List<Zombie> findAll() {
        return zombieDao.findAll();
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
