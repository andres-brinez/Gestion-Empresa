package com.UdeA.Ciclo3.security;

import com.UdeA.Ciclo3.handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

// configuraciones que tratan toda la seguridad de la aplicacion
@Configuration
@EnableWebSecurity // para habilitar la seguridad web
public class secConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_name,password,habilitado from usuario where user_name=?")
                .authoritiesByUsernameQuery("select user_name,rol from usuario where user_name=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /* configuracion iniciar,permite ingresar independientemente el rol
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout().permitAll();


    */
                /*
                -El metodo authorizeRequests() permite restringir y/o dar acceso request HTTP
                -antMatchers(): Lista de URL que corresponden a un RequestMapping como lo hacemos en los controladores.
                -permitAll(): Especifica que estas URLs son accesibles por cualquiera.
                -access(): permite el acceso cumpliendo la expresión, en este caso tenemos la expresion “hasRole()”. Donde verifica si el usuario tiene ese especifico Role.
                -anyRequest(): Ya que la configuración es lineal poniendo este metodo al final interpreta los request a las URLs que no fueron descritos, y en conjunto con el metodo authenticated() permite y da acceso a cualquier usuario que este autenticado.
                 */


        http.authorizeRequests()
                                                      // no es necesario escribir ROLE_, solo el rol
            // con con ** se puede acceder a cualquier subdirectorio es decir que tenga esa ruta
            // como por ejemplo    /Empresa/Editar, /Empresa/Eliminar etc
            .antMatchers("/VerEmpresas/**").hasRole("ADMIN")
            .antMatchers("/VerUsuarios/**").hasRole("ADMIN")
            .antMatchers("/Empresa/**").hasRole("ADMIN")
            .antMatchers("/Empleado/**").hasRole("ADMIN")
            .antMatchers("/VerMovimientos/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/AgregarMovimiento/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/EditarMovimiento/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/Inicio/**").hasAnyRole("ADMIN","USER")
            .antMatchers("/").hasAnyRole("ADMIN","USER")

            .and()
                .formLogin().successHandler(customSuccessHandler)
                .loginPage("/login") // donde será la pagina de login, es decir la ruta de la pagina de login
                .permitAll() // permite el acceso a todos los usuarios
                // si hay algun error aparece esta url, y desde la plantilla se genera un error
                .failureUrl("/login?error=true")
                // estos dos son los campos que se deben enviar en el formulario de login, por eso debe tener el nombre del input de cada uno
                .usernameParameter("username")
                .passwordParameter("password")


            .and()
              .exceptionHandling().accessDeniedPage("/Denegado")// inidica que si el usuario no tiene permiso para acceder a una pagina se le redirecciona a la pagina de denegado

            .and()
                // si se deslogea se le redirecciona a la pagina de login con este url, y aparece un mensaje en la plantilla
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();

    }
}



