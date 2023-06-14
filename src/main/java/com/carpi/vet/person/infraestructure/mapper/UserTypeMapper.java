package com.carpi.vet.person.infraestructure.mapper;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.domain.model.UserType;
import com.carpi.vet.person.infraestructure.data.model.IdentificationTypeData;
import com.carpi.vet.person.infraestructure.data.model.UserTypeData;
import org.springframework.stereotype.Component;

@Component
public class UserTypeMapper {
    public UserType toUserType(UserTypeData userTypeData) {
        return new UserType(userTypeData.getId(), userTypeData.getName());
    }

    public UserTypeData toUserTypeData(UserType userType) {
        return new UserTypeData(userType.getId(), userType.getName());
    }
}
