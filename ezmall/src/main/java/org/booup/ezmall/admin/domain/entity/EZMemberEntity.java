package org.booup.ezmall.admin.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.booup.ezmall.common.Role;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "EZMember")
@NoArgsConstructor
public class EZMemberEntity {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  @Column(length = 20, nullable = false)
  private String name;

  @Column(length = 20, nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @Column(name = "last_access_dt")
  private LocalDateTime lastAccessDt;

  @CreationTimestamp
  private LocalDateTime regDtm;

  @CreationTimestamp
  private LocalDateTime updDtm;

  public EZMemberEntity(long id, String email, String name, String password, Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
