package io.spring2go.authcodeserver.repository;

import io.spring2go.authcodeserver.domain.Credentials;
import io.spring2go.authcodeserver.domain.CredentialsAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CredentialAuthoritiesRepository extends JpaRepository<CredentialsAuthorities, Long> {
    List<CredentialsAuthorities> findByCredentialsId(Long credentialsId);
}
