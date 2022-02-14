package org.booup.ezmall.admin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.booup.ezmall.admin.domain.dto.EZMemberDTO;
import org.booup.ezmall.admin.domain.entity.EZMemberEntity;
import org.booup.ezmall.admin.repository.EZMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EZMemberService implements UserDetailsService {

  @Autowired
  private EZMemberRepository ezMemberRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<EZMemberEntity> memberEntityWrapper = ezMemberRepository.findByEmail(email);
    EZMemberEntity memberEntity = memberEntityWrapper.orElse(null);

    List<GrantedAuthority> authorities = new ArrayList<>();

    authorities.add(new SimpleGrantedAuthority(memberEntity.getRole().name()));

    return new User(memberEntity.getEmail(), memberEntity.getPassword(), authorities);
  }

  public long signUp(EZMemberDTO ezMemberDTO) {
    EZMemberEntity member = ezMemberDTO.toEntity();
    member.setLastAccessDt(LocalDateTime.now());
    member.setRegDtm(LocalDateTime.now());

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    member.setPassword(passwordEncoder.encode(member.getPassword()));
    return ezMemberRepository.save(member).getId();
  }
}
