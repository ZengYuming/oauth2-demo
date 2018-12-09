package io.spring2go.authcodeserver.config;

import io.spring2go.authcodeserver.domain.Authority;
import io.spring2go.authcodeserver.domain.Credentials;
import io.spring2go.authcodeserver.domain.CredentialsAuthorities;
import io.spring2go.authcodeserver.repository.AuthorityRepository;
import io.spring2go.authcodeserver.repository.CredentialAuthoritiesRepository;
import io.spring2go.authcodeserver.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("jdbcUserDetails")
public class JdbcUserDetails implements ClientDetailsService {
    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private CredentialAuthoritiesRepository credentialAuthoritiesRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Credentials credentials = credentialRepository.findByName(clientId);
        //如果正式不存在，则不该器授权
        if (credentials == null) {
            throw new UsernameNotFoundException("User" + clientId + "can not be found");
        }
        List<CredentialsAuthorities> credentialsAuthoritiesList = credentialAuthoritiesRepository.findByCredentialsId(credentials.getId());
        List<Long> authorityIdList = new ArrayList<>();
        for (CredentialsAuthorities x : credentialsAuthoritiesList) {
            authorityIdList.add(x.getAuthoritiesId());
        }
        List<Authority> authorityList = authorityRepository.findAll(authorityIdList);

        return new BaseClientDetails(clientId, "", "read_userinfo", "authorization_code", authorityList.get(0).getAuthority());
    }
}
