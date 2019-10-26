package otp.junctionx.atm.finder.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import otp.junctionx.atm.finder.dto.*;
import otp.junctionx.atm.finder.model.Atm;
import otp.junctionx.atm.finder.repository.AtmRepository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AtmFinderService {

    AtmRepository repository;

    public AtmFinderService(AtmRepository repository) {
        this.repository = repository;
    }

    public List<AtmResponse> getAllAtmWithAllInfo(SearchRequest searchRequest) {
        /*
        ObjectMapper mapper = new ObjectMapper();

        try {
            GoogleMapsData googleMapsData = mapper.readValue("", GoogleMapsData.class);

            List<AtmData> atmData = readAtmLocationResponseFromJson();
            return Arrays.asList(AtmResponse.builder().coord(atmData.get(0).coord).build());
        } catch (IOException ioe) {
            log.info("Json reading failed.");
            return Arrays.asList(new AtmResponse());
        }

        if (searchRequest.isDepositRequired)
            return Arrays.asList(AtmResponse.builder().id("yeah its true").build());
        else
            return Arrays.asList(AtmResponse.builder().id("yeah its false").build());
         */
        return null;
    }

    public List<AtmData> getAllAtmLocations() {
        return readAtmLocationResponseFromJson();
    }

    public void writeSelectedAtm(String id) {
        Optional<Atm> atmOptional = repository.findById(id);
        Atm atm;

        if (atmOptional.isPresent()) {
            atm = atmOptional.get();
            int customerCount = atm.getExpectedCustomers();
            atm.setExpectedCustomers(customerCount + 1);
        } else {
            atm = new Atm();
            atm.setId(id);
            atm.setExpectedCustomers(1);
        }

        repository.save(atm);
    }

    private List<AtmData> readAtmLocationResponseFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<AtmData> atmData = mapper.readValue(new File("\\files\\data.json"), new TypeReference<List<AtmData>>() {});
            return Arrays.asList(AtmData.builder().coord(atmData.get(0).coord).build());
        } catch (IOException ioe) {
            log.info("Json reading failed.");
            return Arrays.asList(new AtmData());
        }
    }

}
