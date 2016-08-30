package net.szaboferee.sample.betting.rest.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app-info")
public class AppInfoController {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "OK";
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String version() {
        return this.getClass().getPackage().getImplementationVersion();
    }

}
