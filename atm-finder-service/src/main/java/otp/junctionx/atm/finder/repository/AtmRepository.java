package otp.junctionx.atm.finder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import otp.junctionx.atm.finder.model.Atm;

import java.util.Optional;

public interface AtmRepository extends MongoRepository<Atm, String> {

    @Override
    Optional<Atm> findById(String id);

}
