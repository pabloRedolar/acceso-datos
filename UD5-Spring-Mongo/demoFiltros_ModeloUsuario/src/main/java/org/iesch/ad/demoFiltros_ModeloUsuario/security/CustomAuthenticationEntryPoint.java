package org.iesch.ad.demoFiltros_ModeloUsuario.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet() {
        setRealmName("IESCH");
        super.afterPropertiesSet();
    }
}
