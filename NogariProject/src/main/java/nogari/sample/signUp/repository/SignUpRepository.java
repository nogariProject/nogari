package nogari.sample.signUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nogari.sample.domain.entity.MemberEntity;

public interface SignUpRepository extends JpaRepository<MemberEntity, String> {

}