package mangosoft.service.impl;

import java.util.List;
import mangosoft.model.User;
import mangosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mangosoft.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {

        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public List<User> findAll(int page, int size, boolean asc, String propertySort) {
        Sort sort;
        if(asc){
            sort = new Sort(Sort.Direction.ASC, propertySort);
        }else{
            sort = new Sort(Sort.Direction.DESC, propertySort);
        }
        Page<User> users = userRepository.findAll(new PageRequest(page, size, sort));
        return users.getContent();
    }

    @Override
    public int countUsers() {
        return userRepository.countUsers();
    }


}
