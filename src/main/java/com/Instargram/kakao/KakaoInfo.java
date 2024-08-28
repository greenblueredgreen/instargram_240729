package com.Instargram.kakao;

import lombok.Getter;
import lombok.NoArgsConstructor;

//https://kauth.kakao.com/oauth/authorize?client_id=052f56900201a40aa25887940e84b715&redirect_uri=http://localhost/user/sign-in-view&response_type=code
@Getter
@NoArgsConstructor
public class KakaoInfo {
    private Long id;
    private String nickname;
    private String email;

    public KakaoInfo(Long id, String nickname, String email) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }
}