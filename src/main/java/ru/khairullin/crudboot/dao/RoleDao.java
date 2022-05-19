package ru.khairullin.crudboot.dao;

import ru.khairullin.crudboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface RoleDao extends JpaRepository<Role, Long> {
}