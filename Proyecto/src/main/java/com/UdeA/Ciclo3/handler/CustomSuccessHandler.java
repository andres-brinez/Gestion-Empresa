package com.UdeA.Ciclo3.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component // indica que esto debe verificarce al inicio del proceso (despues de la autenticacion)
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    // en el caso de que el usuario se autentique correctamente
    // indicamos que se debe hacer despues del logi
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); // nueve elemento para redireccionar

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication); //LLamo al metodo que me da la url a donde debo ir
        if (response.isCommitted()) {
            // si hay un error
            System.out.println("No se puede redireccionar");
            return;
        }
        // redireccionar a la url que se obtuvo en el metodo anterior
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // verifica el rol, esto se trajo de la base de datos en setConfig

        List<String> roles = new ArrayList<String>();  // crear  lista para guardar  los roles

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority()); // guarda los tipos de roles que hay en la base de datos en una  lista
        }

        // si el usuario tiene el rol de admin, se redirecciona a la pagina de admin
        if (esAdministrativo(roles)) {
            url = "/Inicio";
        } else if (esOperativo(roles)) {
            url = "VerMovimientos";
        }
        // si no tiene permisos el usuario
        else {
            url = "/Denegado";
        }
        return url;
    }


    // metodos para verificar que tipo de rol es el usuario
    // itera los roles que hay en la  lista roles
    private boolean esOperativo(List<String> roles) {
        if (roles.contains("ROLE_USER")) {
            return true;
        }
        return false;
    }

    private boolean esAdministrativo(List<String> roles) {
        if (roles.contains("ROLE_ADMIN")) {
            return true;
        }
        return false;


    }



}
