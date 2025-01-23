package com.example.bootstickverwaltung.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import java.util.Collections;

@Configuration
@EnableLdapRepositories
public class AdLdapConfig {

    @Value("${spring.ldap.urls}")
    private String url;

    @Value("${spring.ldap.domain}")
    private String domain;

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider authenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider =
                new ActiveDirectoryLdapAuthenticationProvider(domain, url);

        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);
        // Falls du @student.tgm.ac.at verwendest:
        provider.setSearchFilter("(sAMAccountName={0})");




        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            ActiveDirectoryLdapAuthenticationProvider adProvider) {
        return new ProviderManager(Collections.singletonList(adProvider));
    }

    @PostConstruct
    public void init() {
        System.out.println("DEBUG - spring.ldap.username=" + url); // Test, ob richtig geladen
        System.out.println("DEBUG - AD_USER from environment=" + System.getenv("AD_USER"));
        System.out.println("LDAP URL: " + url);
        System.out.println("LDAP Domain: " + domain);

    }

}
