package com.user.dto.resp;

import lombok.Data;

import java.util.List;
@Data
public class UserInfoDateil {
    List<String> roles;
    String introduction;
    String avatar;
    String name;
    Long realm;
}
