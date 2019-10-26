package otp.junctionx.atm.finder.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import otp.junctionx.atm.finder.dto.AtmData;
import otp.junctionx.atm.finder.dto.AtmResponse;
import otp.junctionx.atm.finder.dto.AtmLocationResponse;
import otp.junctionx.atm.finder.dto.SearchRequest;
import otp.junctionx.atm.finder.repository.AtmRepository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class AtmFinderService {

    AtmRepository repository;

    public AtmFinderService(AtmRepository repository) {
        this.repository = repository;
    }

    public AtmResponse getAllAtmWithAllInfo(SearchRequest searchRequest) {
        if (searchRequest.isDepositRequired)
            return AtmResponse.builder().id("yeah its true").build();
        else
            return AtmResponse.builder().id("yeah its false").build();

    }

    public List<AtmLocationResponse> getAllAtmLocations() {
        List<AtmData> atmData = readAtmLocationResponseFromJson();
        return Arrays.asList(AtmLocationResponse.builder().coord(atmData.get(0).coord).build());
    }

    public void writeSelectedAtm(String id) {
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
