package io.spring2go.clientserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * 授权服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("myClientDetailsService")
    ClientDetailsService clientDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        inDb(clients);
    }

    /**
     * 客户端凭证放在数据库中
     *
     * @param clients
     * @throws Exception
     */
    private void inDb(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 客户端凭证放在内存中
     *
     * @param clients
     * @throws Exception
     */
    @Deprecated
    private void inMemory(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientdevops")
                // 密码模式
                .secret("789")
                .authorizedGrantTypes("client_credentials")
                .scopes("devops");
    }
}
