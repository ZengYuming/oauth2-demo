package io.spring2go.clientserver.api;

import java.util.ArrayList;
import java.util.List;

import io.spring2go.clientserver.vo.response.UserInfoRes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class DevOpsController {

    @RequestMapping("/userlist")
    public ResponseEntity<List<UserInfoRes>> getAllUsers() {
        return ResponseEntity.ok(getUsers());
    }

    private List<UserInfoRes> getUsers() {
        List<UserInfoRes> users = new ArrayList<>();
        users.add(new UserInfoRes("bobo", "bobo@spring2go.com"));
        users.add(new UserInfoRes("eric", "eric@spring2go.com"));
        users.add(new UserInfoRes("franky", "franky@spring2go.com"));

        return users;
    }
}
