package org.booup.ezmall.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.booup.ezmall.admin.domain.dto.EZMemberDTO;
import org.booup.ezmall.admin.service.EZMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class EZAdminController {

  @Autowired
  private EZMemberService memberService;

  @GetMapping("login")
  public String adminSignUp() {
    return "login";
  }

  @PostMapping("login")
  public String execLogin(EZMemberDTO ezMemberDTO) {
    memberService.signUp(ezMemberDTO);
    return "redirect:/login";
  }

  @GetMapping("signup")
  public String adminSignIn(){ return "signup"; }

  @PostMapping("signup")
  public String execSignUp(EZMemberDTO ezMemberDTO){
    log.debug(ezMemberDTO.toString());
    memberService.signUp(ezMemberDTO);
    return "redirect:/login";
  }
}
