package mangosoft.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mangosoft.repository.UserRepository;

import java.util.Collections;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        mangosoft.model.User user = userRepository.findByUsername(username);

        if (user != null) {
            return new User(user.getUsername(), user.getPassword(), getAuthority());
        }

        throw new UsernameNotFoundException(username + " not found!");
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
