package se.lexicon.g52todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g52todoapi.converter.RoleConverter;
import se.lexicon.g52todoapi.converter.RoleConverterImpl;
import se.lexicon.g52todoapi.domain.dto.RoleDTOForm;
import se.lexicon.g52todoapi.domain.dto.RoleDTOView;
import se.lexicon.g52todoapi.domain.dto.UserDTOForm;
import se.lexicon.g52todoapi.domain.dto.UserDTOView;
import se.lexicon.g52todoapi.domain.entity.Role;
import se.lexicon.g52todoapi.domain.entity.User;
import se.lexicon.g52todoapi.repository.RoleRepository;
import se.lexicon.g52todoapi.repository.UserRepository;
import se.lexicon.g52todoapi.service.RoleService;
import se.lexicon.g52todoapi.service.UserService;

import java.util.HashSet;
import java.util.Set;

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

        Set<RoleDTOForm> roles = userDTOForm.getRoles();
        Set<RoleDTOView> rolesConverted = new HashSet<RoleDTOView>();
        for (RoleDTOForm element : roles) {
            Role commonRole = roleConverterImpl.toEntity(element);
            rolesConverted.add(roleConverterImpl.toRoleDto(commonRole));
        }
        return new UserDTOView(userDTOForm.getEmail(), rolesConverted);
    }

    @Override
    public UserDTOView getByEmail(String email) {

        User user = userRepository.findById(email).orElse(null);
        if(user == null) {
            return null;
        }
        Set<RoleDTOView> roles = new HashSet<>();
        user.getRoles().forEach(role -> {
            roles.add(roleConverterImpl.toRoleDto(role));
        });

        return new UserDTOView(email, roles);
    }

    @Override
    public void disableByEmail(String email) {
        User user = userRepository.findById(email).orElse(null);
        if(user == null) {
            return;
        }
        user.setExpired(true);
    }

    @Override
    public void enableByEmail(String email) {
        User user = userRepository.findById(email).orElse(null);
        if(user == null) {
            return;
        }
        user.setExpired(false);
    }
}
