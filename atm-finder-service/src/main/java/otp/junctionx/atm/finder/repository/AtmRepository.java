package otp.junctionx.atm.finder.repository;

import org.springframework.data.repository.CrudRepository;
import otp.junctionx.atm.finder.model.Atm;

import java.util.Optional;

public interface AtmRepository extends CrudRepository<Atm, String> {

    @Override
    Optional<Atm> findById(String id);

}
