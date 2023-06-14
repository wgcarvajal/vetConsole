package com.carpi.vet.person.infraestructure.mapper;

import com.carpi.vet.person.domain.model.User_;
import com.carpi.vet.person.infraestructure.data.model.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final UserTypeMapper userTypeMapper;
    public User_ toUser(UserData userData) {
        return new User_(userData.getId(), userData.getEmail(),userData.getPassword(),userTypeMapper.toUserType(userData.getUserTypeData()));
    }

    public UserData toUserData(User_ user) {
        return new UserData(user.getId(),userTypeMapper.toUserTypeData(user.getUserType()), user.getEmail(),user.getPassword());
    }
}
