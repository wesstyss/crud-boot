package ru.khairullin.crudboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.khairullin.crudboot.dao.RoleDao;
import ru.khairullin.crudboot.model.Role;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return new HashSet<>(roleDao.findAllById(roles));
    }

    @Override
    @PostConstruct
    public void addDefaultRole() {
        roleDao.save(new Role(1L,"ROLE_USER"));
        roleDao.save(new Role(2L,"ROLE_ADMIN"));
    }
}