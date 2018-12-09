package io.spring2go.authcodeserver.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 证书
 * 用于存放 帐号&密码，来换取授权（authority）
 */
@Entity
@Table(name = "credentials")
public class Credentials implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Integer version;
    @Column(name = "name")
    private String name;
    private String password;
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
