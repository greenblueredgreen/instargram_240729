package com.Instargram.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Instargram.kakao.bo.KakaoService;
import com.Instargram.kakao.domain.KakaoUserInfoResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class KakaoLoginController {

	//http://localhost/callback?code=RyCUAFRRNutT4xW71Wu443DPWK6s64a0i0kVJEXnebRM6Oj4gxJmbwAAAAQKPCSaAAABkaKXxbDUNEQ5evY1pg
    private final KakaoService kakaoService;

    @GetMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam("code") String code) {
        String accessToken = kakaoService.getAccessTokenFromKakao(code);

        KakaoUserInfoResponseDto userInfo = kakaoService.getUserInfo(accessToken);

        // User 로그인, 또는 회원가입 로직 추가
        return new ResponseEntity<>(HttpStatus.OK);
    }
}