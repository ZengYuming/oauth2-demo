package io.spring2go.authcodeserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * 授权服务器
 * 参考：https://github.com/jiangchao123/spring-cloud-security-oauth2-jdbc/blob/master/oauth-server/src/main/java/cn/com/sina/alan/oauth/config/OAuthSecurityConfig.java
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("jdbcUserDetails")
    ClientDetailsService clientDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        super.configure(security);
        security.allowFormAuthenticationForClients();
    }
//
//    /**
//     * (用数据库模式，即，用户信息在数据库维护)配置是授权服务器
//     *
//     * @param clients
//     */
//    private void configAuthorizationServerInDB(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(clientDetailsService);
//    }
//
//    /**
//     * (用Memory模式)配置是授权服务器
//     * Memory模式只适用于测试环境
//     *
//     * @param clients
//     */
//    @Deprecated
//    private void configAuthorizationServerInMemory(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                //clientId+secret=用户凭证
//                .withClient("clientapp")
//                .secret("112233")
//                //重定向url，即，拿到授权码之后，怎么跳转
//                .redirectUris("http://localhost:9001/callback")
//                // （明确告诉授权服务器，我只支持）授权码模式
//                .authorizedGrantTypes("authorization_code")
//                //用scopes来细分权限
//                .scopes("read_userinfo", "read_contacts");
//    }
}
