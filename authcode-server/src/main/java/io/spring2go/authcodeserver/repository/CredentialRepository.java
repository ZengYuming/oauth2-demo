package io.spring2go.authcodeserver.repository;

import io.spring2go.authcodeserver.domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CredentialRepository extends JpaRepository<Credentials, Long> {
    Credentials findByName(String name);
}
