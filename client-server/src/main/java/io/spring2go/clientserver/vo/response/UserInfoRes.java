package io.spring2go.clientserver.vo.response;

public class UserInfoRes {
    private String name;

    private String email;

    public UserInfoRes(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
