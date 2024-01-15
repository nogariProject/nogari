package nogari.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nogari.entity.MemberEntity;

public interface AccountRepository extends JpaRepository<MemberEntity, String> {

}