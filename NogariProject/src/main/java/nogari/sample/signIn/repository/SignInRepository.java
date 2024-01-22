package nogari.sample.signIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nogari.sample.domain.entity.MemberEntity;

public interface SignInRepository extends JpaRepository<MemberEntity, String> {

}