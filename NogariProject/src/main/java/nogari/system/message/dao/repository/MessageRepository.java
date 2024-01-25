package nogari.system.message.dao.repository;

import nogari.system.message.domain.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long>{}
