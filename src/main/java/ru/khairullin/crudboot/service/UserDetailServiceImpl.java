package ru.khairullin.crudboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khairullin.crudboot.dao.UserDao;
import ru.khairullin.crudboot.model.User;

@Transactional
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    UserDao userDao;

    @Autowired
    public UserDetailServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}
