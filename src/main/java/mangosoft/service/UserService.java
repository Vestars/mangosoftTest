
package mangosoft.service;

import mangosoft.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
    void deleteUser(String username);
    List<User> findAll(int page, int size, boolean asc, String propertySort);
    int countUsers();
}
