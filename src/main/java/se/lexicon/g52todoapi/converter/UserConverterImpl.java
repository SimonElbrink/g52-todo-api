package se.lexicon.g52todoapi.converter;

import se.lexicon.g52todoapi.domain.dto.RoleDTOForm;
import se.lexicon.g52todoapi.domain.dto.RoleDTOView;
import se.lexicon.g52todoapi.domain.dto.UserDTOForm;
import se.lexicon.g52todoapi.domain.dto.UserDTOView;
import se.lexicon.g52todoapi.domain.entity.Role;
import se.lexicon.g52todoapi.domain.entity.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserConverterImpl implements UserConverter {

    @Override
    public UserDTOView toUserDto(User entity) {
        Set<RoleDTOView> rolesDTO  = new HashSet<>();
        for (Role role : entity.getRoles()) {
            rolesDTO.add(new RoleDTOView(role.getId(), role.getName()));
        }

         return new UserDTOView(entity.getEmail(), rolesDTO);

    }



    @Override
    public User toEntity(UserDTOForm dto) {
        Set<Role> roles = new HashSet<>();
        for (RoleDTOForm roleDTOForm : dto.getRoles()) {
            roles.add(new Role(roleDTOForm.getId(), roleDTOForm.getName()));
        }

        return new User(dto.getEmail(), dto.getPassword(), roles);
    }
}

