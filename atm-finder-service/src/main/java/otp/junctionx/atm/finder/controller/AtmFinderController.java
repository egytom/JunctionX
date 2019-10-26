package otp.junctionx.atm.finder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import otp.junctionx.atm.finder.dto.AllAtmResponse;
import otp.junctionx.atm.finder.service.AtmFinderService;

@Slf4j
@RestController
public class AtmFinderController {

    AtmFinderService service;

    public AtmFinderController(AtmFinderService service) {
        this.service = service;
    }

    @GetMapping("/all-atm/{deposit}")
    public AllAtmResponse add(@PathVariable String deposit) {
        log.info("Get http request through /all-atm/{deposit} url path.");
        if (deposit.equals("true"))
            return AllAtmResponse.builder().test("yeah its true").build();
        else
            return AllAtmResponse.builder().test("yeah its false").build();

    }

}
