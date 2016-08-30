package net.szaboferee.sample.betting.monitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.szaboferee.sample.betting.domain.Bet;

import org.springframework.beans.factory.annotation.Autowired;

public class BetToMonitorEventConverter {

    private ObjectMapper objectMapper;

    @Autowired
    public BetToMonitorEventConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String updateBet(Bet bet) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new MonitoringEvent(bet.getId(), "updated", System.currentTimeMillis()));
    }

    public String createBet(Bet bet) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new MonitoringEvent(bet.getId(), "created", System.currentTimeMillis()));
    }
}
