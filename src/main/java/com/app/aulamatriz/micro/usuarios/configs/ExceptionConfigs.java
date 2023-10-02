package com.app.aulamatriz.micro.usuarios.configs;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component//control
@ConfigurationProperties(prefix = "control")
public class ExceptionConfigs {

    //control.exception
    private Map<String,String> exception;

    public static final String PERZONALIZADA="personalizada";

    public static final String SYSTEMA="system";

    private String getTipoExcepciones(final String tipoExcepcion){
        return exception.get(tipoExcepcion);
    }

}
