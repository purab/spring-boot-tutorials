package in.purabtech.mongodb.api.repository;

import in.purabtech.mongodb.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EcommerceRepository extends MongoRepository<User, Integer> {
    List<User> findByName(String name);

    @Query("{'Address.city':?0}")
    List<User> findByCity(String city);
}
