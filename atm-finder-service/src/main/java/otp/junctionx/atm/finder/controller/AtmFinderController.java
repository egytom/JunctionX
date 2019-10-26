package otp.junctionx.atm.finder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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
    public AllAtmResponse add(@RequestAttribute String deposit) {
        log.info("Get http request through /all-atm url path.");
        return AllAtmResponse.builder().test("yeah").build();
    }

}
