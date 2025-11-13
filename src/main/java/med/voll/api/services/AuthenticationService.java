package med.voll.api.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import med.voll.api.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService{

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByLogin(username);
    }
    
}
