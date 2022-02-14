package org.booup.ezmall.admin.domain.dto;

import java.time.LocalDateTime;
import org.booup.ezmall.admin.domain.entity.EZMemberEntity;
import org.booup.ezmall.common.Role;

public class EZMemberDTO {
  private Integer id;

  private String email;

  private String name;

  private String password;

  private Role role;

  private LocalDateTime lastAccessDt;

  private LocalDateTime regDt;

  public EZMemberEntity toEntity() {
    return new EZMemberEntity(id,email, name, password, role);
  }
}
