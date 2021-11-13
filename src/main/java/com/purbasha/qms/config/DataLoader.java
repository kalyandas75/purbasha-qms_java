package com.purbasha.qms.config;

import com.purbasha.qms.domain.User;
import com.purbasha.qms.repository.UserRepository;
import com.purbasha.qms.security.AuthoritiesConstants;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!this.userRepository.findOneByEmailIgnoreCase("superAdmin@purbashaqms.com").isPresent()) {
            User superAdmin = new User();
            superAdmin.setPassword(passwordEncoder.encode("changeme123"));
            superAdmin.setActivate(true);
            superAdmin.setAuthority(AuthoritiesConstants.SUPER_ADMIN);
            superAdmin.setEmail("superAdmin@purbashaqms.com");
            superAdmin.setName("System");
            superAdmin.setLogin("purbasha.sysadmin");
            userRepository.save(superAdmin);


            User anonymous = new User();
            anonymous.setPassword(passwordEncoder.encode("changeme123"));
            anonymous.setActivate(true);
            anonymous.setAuthority(AuthoritiesConstants.ANONYMOUS);
            anonymous.setEmail("anonymous@purbashaqms.com");
            anonymous.setName("Anonymous");
            anonymous.setLogin("anonymous");
            userRepository.save(anonymous);
        }
    }
}
