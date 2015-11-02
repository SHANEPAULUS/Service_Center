package com.shane.servicecenter.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SHANE on 2015/08/12.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
   // @Autowired
   // private StationService service;

    @RequestMapping(value="home",method= RequestMethod.GET)
    public String Index(){return "<html>\n" +
            "<head>\n<title>Welcome to Shane's center</title>\n</head>\n<body>\n<h1>Welcome to Shane's" +
            " Vehicle Service Center</h1>\n"+
	"<p>Technical Programming Assignment..</p></body>\n</html>";}
/*
    @RequestMapping(value="/station",method = RequestMethod.GET)
    public Station getStation()
    {
        return null;
    }

    @RequestMapping(value="/stations",method = RequestMethod.GET)
    public List<Station> getStations(){return service.getStations();}
    */
}
