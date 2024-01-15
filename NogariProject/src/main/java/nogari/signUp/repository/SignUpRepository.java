package nogari.signUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nogari.entity.MemberEntity;

public interface SignUpRepository extends JpaRepository<MemberEntity, String> {

}