package com.bolsasdeidead.springboot.backend.apirest.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private InfoAdicionalToken infoAdicionalToken;
	
	
	@Autowired
	@Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;


	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()") //permiAll() dar permisos a cualquier usuarios o anonimos
		.checkTokenAccess("isAuthenticated()"); //Endpoint que verifica el token y su firma
	}


	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//passwordEncoder para encriptar y codificar la contraseña
		clients.inMemory().withClient("angularapp")
		.secret(passwordEncoder.encode("12345"))
		.scopes("read","write") //permiso de lectura y escritura
		.authorizedGrantTypes("password","refresh_token") //tipo de consesion de nuestra autenticacion
	    .accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
	}


	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken,accessTokenConverter()));
	   
		endpoints.authenticationManager(authenticationManager)
        .tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter())
        .tokenEnhancer(tokenEnhancerChain);
	   
	}

    
	@Bean
 	public JwtTokenStore tokenStore() {
		// TODO Auto-generated method stub
		return new JwtTokenStore(accessTokenConverter());
	}


	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		// TODO Auto-generated method stub
       JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
       jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA); //el que firma el token rsa_privada
       jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);//firmamos el jwt validar si el token es autentico 
       return jwtAccessTokenConverter;
	}
	
	
}
