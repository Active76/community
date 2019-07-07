package cn.fjj.community.controller;

import cn.fjj.community.controller.dto.AccessTokenDTO;
import cn.fjj.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("541523f41d998f30a53b");
        accessTokenDTO.setClient_secret("2e9167a69c228b1150ed0c9ad1aef830024c31d9");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
