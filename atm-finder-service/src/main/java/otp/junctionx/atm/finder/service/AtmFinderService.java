package otp.junctionx.atm.finder.service;

import org.springframework.stereotype.Service;
import otp.junctionx.atm.finder.repository.AtmRepository;

@Service
public class AtmFinderService {

    AtmRepository repository;

    public AtmFinderService(AtmRepository repository) {
        this.repository = repository;
    }

}
