package net.szaboferee.sample.betting.service;

import net.szaboferee.sample.betting.domain.Bet;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

public interface BetService {
    Bet createBet(Bet bet);

    Bet updateBet(Bet bet);

    @Payload("new java.util.Date()")
    List<Bet> listBets();
}
