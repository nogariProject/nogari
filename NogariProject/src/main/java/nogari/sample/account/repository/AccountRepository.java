package nogari.sample.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nogari.sample.domain.entity.MemberEntity;

public interface AccountRepository extends JpaRepository<MemberEntity, String> {

}