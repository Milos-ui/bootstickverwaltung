package com.example.bootstickverwaltung.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import java.util.Collections;

@Configuration
@EnableLdapRepositories(basePackages = "com.example.bootstickverwaltung.ldap.repository")
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
        provider.setSearchFilter("(sAMAccountName={0})");
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(ActiveDirectoryLdapAuthenticationProvider adProvider) {
        return new ProviderManager(Collections.singletonList(adProvider));
    }
}
