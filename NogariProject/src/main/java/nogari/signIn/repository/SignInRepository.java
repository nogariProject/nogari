package nogari.signIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nogari.entity.MemberEntity;

public interface SignInRepository extends JpaRepository<MemberEntity, String> {

}