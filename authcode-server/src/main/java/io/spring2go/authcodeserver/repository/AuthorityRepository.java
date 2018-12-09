package io.spring2go.authcodeserver.repository;

import io.spring2go.authcodeserver.domain.Authority;
import io.spring2go.authcodeserver.domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
