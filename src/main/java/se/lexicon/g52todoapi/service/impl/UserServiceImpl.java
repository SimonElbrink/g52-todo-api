package se.lexicon.g52todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g52todoapi.domain.dto.UserDTOForm;
import se.lexicon.g52todoapi.domain.dto.UserDTOView;
import se.lexicon.g52todoapi.repository.UserRepository;
import se.lexicon.g52todoapi.repository.RoleRepository;
import se.lexicon.g52todoapi.converter.RoleConverterImpl;

import se.lexicon.g52todoapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    RoleConverterImpl roleConverterImpl;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, RoleConverterImpl roleConverterImpl) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleConverterImpl = roleConverterImpl;
    }

    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {
        //Todo: Implement the method
        return null;
    }

    @Override
    public UserDTOView getByEmail(String email) {
        //Todo: Implement the method
        return null;
    }

    @Override
    public void disableByEmail(String email) {
        //Todo: Implement the method

    }

    @Override
    public void enableByEmail(String email) {
        //Todo: Implement the method

    }
}
