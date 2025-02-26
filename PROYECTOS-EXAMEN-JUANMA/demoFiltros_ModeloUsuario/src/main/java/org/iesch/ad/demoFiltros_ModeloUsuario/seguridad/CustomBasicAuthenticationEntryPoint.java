package org.iesch.ad.demoFiltros_ModeloUsuario.seguridad;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet() {
        setRealmName("IESCH");
        super.afterPropertiesSet();
    }
}
