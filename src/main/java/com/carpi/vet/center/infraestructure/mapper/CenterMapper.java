package com.carpi.vet.center.infraestructure.mapper;

import com.carpi.vet.center.domain.model.Center;
import com.carpi.vet.center.domain.model.response.CenterResponse;
import com.carpi.vet.center.infraestructure.data.model.CenterData;
import org.springframework.stereotype.Component;

@Component
public class CenterMapper {

    public Center toCenter(CenterData centerData) {
        return new Center(
                centerData.getId(),
                centerData.getName(),
                centerData.getAddress(),
                centerData.getPhone());
    }

    public CenterData toCenterData(Center center) {
        return new CenterData(
                center.getId(),
                center.getName(),
                center.getAddress(),
                center.getPhone());
    }

    public CenterResponse toCenterResponse(CenterData centerData) {
        return new CenterResponse(
                centerData.getId(),
                centerData.getName(),
                centerData.getAddress(),
                centerData.getPhone(),
                null
        );
    }
}
