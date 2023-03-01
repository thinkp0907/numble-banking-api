package com.numble.banking.service;

import com.numble.banking.dto.ClientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NumbleAlarmService {

    private static Logger LOGGER = LoggerFactory.getLogger(NumbleAlarmService.class);

    public void notify(ClientDto clientDto, String message) {
        LOGGER.info(message);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }


}
