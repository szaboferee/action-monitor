package net.szaboferee.sample.betting.rest.contorller;

import net.szaboferee.sample.betting.domain.Bet;
import net.szaboferee.sample.betting.service.BetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/bet")
public class BetController {

    private BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Bet addBet(@RequestParam("amount") BigDecimal amount) {
        Bet bet = new Bet();
        bet.setAmount(amount);

        return betService.createBet(bet);
    }

    @RequestMapping(value = "/{betId}", method = RequestMethod.PUT)
    public Bet updateBet(@PathVariable Integer betId, @RequestParam("amount") BigDecimal amount) {
        Bet bet = new Bet();
        bet.setId(betId);
        bet.setAmount(amount);

        return betService.updateBet(bet);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Bet> betList() {
        return betService.listBets();
    }

}
