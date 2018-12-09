package io.spring2go.authcodeserver.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credentials_authorities")
public class CredentialsAuthorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 证书ID
     */
    @Column(name = "credentials_id")
    private Long credentialsId;
    /**
     * 授权ID
     */
    @Column(name = "authorities_id")
    private Long authoritiesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(Long credentialsId) {
        this.credentialsId = credentialsId;
    }

    public Long getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(Long authoritiesId) {
        this.authoritiesId = authoritiesId;
    }
}
