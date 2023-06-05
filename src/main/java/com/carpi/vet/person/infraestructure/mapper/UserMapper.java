package com.carpi.vet.person.infraestructure.mapper;

import com.carpi.vet.person.domain.model.User_;
import com.carpi.vet.person.infraestructure.data.model.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User_ toUser(UserData userData) {
        return new User_(userData.getId(), userData.getEmail(),userData.getPassword());
    }

    public UserData toUserData(User_ user) {
        return new UserData(user.getId(), user.getEmail(),user.getPassword());
    }
}
