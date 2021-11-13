package com.purbasha.qms.aop.client;


import com.purbasha.qms.domain.User;
import com.purbasha.qms.repository.UserRepository;
import com.purbasha.qms.security.SecurityUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Aspect
@Component
public class ClientAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private final String fieldName =  "clientId";

    private final Logger log = LoggerFactory.getLogger(ClientAspect.class);

    /**
     * Run method if User service is hit.
     * Filter users based on which client the user is associated with.
     * Skip filter if user has no client
     */
    @Before("execution(* com.purbasha.qms.service.UserService.*(..)) || " +
        "execution(* com.purbasha.qms.service.ClientService.*(..)) || " +
        "execution(* com.purbasha.qms.service.FactoryService.*(..)) || " +
        "execution(* com.purbasha.qms.service.FactoryUnitService.*(..)) || " +
        "execution(* com.purbasha.qms.service.UserService.*(..))")
    public void beforeExecution() throws Throwable {
        Optional<String> login = SecurityUtils.getCurrentUserLogin();

        if(login.isPresent()) {
			User user = userRepository.findOneByLoginIgnoreCase(login.get()).get();

			if (user.getClient() != null) {
				Filter filter = entityManager.unwrap(Session.class).enableFilter("CLIENT_FILTER");
				filter.setParameter(fieldName, user.getClient().getId());
			}
		}
    }
}
