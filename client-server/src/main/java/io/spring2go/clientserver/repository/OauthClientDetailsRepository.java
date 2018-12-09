package io.spring2go.clientserver.repository;

import io.spring2go.clientserver.domain.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, Long> {
    OauthClientDetails findByClientId(String clientId);
}