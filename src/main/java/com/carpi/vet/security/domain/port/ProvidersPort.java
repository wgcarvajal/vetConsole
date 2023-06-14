package com.carpi.vet.security.domain.port;

import org.springframework.security.core.Authentication;

public interface ProvidersPort {
    Authentication execute(Object object);
}
