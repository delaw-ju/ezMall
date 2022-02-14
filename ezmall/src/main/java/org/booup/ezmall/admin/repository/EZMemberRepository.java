package org.booup.ezmall.admin.repository;

import java.util.Optional;
import org.booup.ezmall.admin.domain.entity.EZMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EZMemberRepository extends JpaRepository<EZMemberEntity, Long> {

  Optional<EZMemberEntity> findByEmail(String userEmail);

}
