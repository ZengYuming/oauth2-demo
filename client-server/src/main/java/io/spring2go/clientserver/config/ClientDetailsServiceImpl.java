package io.spring2go.clientserver.config;

import io.spring2go.clientserver.domain.OauthClientDetails;
import io.spring2go.clientserver.repository.OauthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * 实现ClientDetailsService，用于查询客户端的信息（client_id+client_secret）
 * 注意：这里的service别名，不能直接叫做clientDetailsService,否则，识别不了
 */
@Service("myClientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Autowired
    OauthClientDetailsRepository oauthClientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClientDetails oauthClientDetails = oauthClientDetailsRepository.findByClientId(clientId);
        //如果正式不存在，则不该器授权
        if (oauthClientDetails == null) {
            throw new UsernameNotFoundException("User" + clientId + "can not be found");
        }
        BaseClientDetails clientDetails = new BaseClientDetails(oauthClientDetails.getClientId(), "", "", "client_credentials", "");
        clientDetails.setClientSecret(oauthClientDetails.getClientSecret());
        return clientDetails;
    }
}
