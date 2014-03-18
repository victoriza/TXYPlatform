package es.moodbox.txy.controller;

import com.sun.deploy.util.SearchPath;
import es.moodbox.txy.model.Meetup;
import es.moodbox.txy.service.MeetupService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by victor on 17/03/14.
 */

@Controller
@RequestMapping("/meetup")
public class MeetupController {

    @Autowired
    private MeetupService meetupService;

    private final static Logger log = Logger.getLogger(MeetupService.class.getName());

    /**
     * For every request for this controller, this will
     * create a person instance for the form.
     */
    @ModelAttribute
    public Meetup newRequest(@RequestParam(required = false) Integer id) {

        return new Meetup();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("meetup", "command", new Meetup());
    }

    @RequestMapping(value = "/addMeetup", method = RequestMethod.POST)
    public ModelAndView addMeetup(@ModelAttribute("meetup") Meetup meetup, BindingResult result) {

        log.log(Level.INFO, "@@ Adding meetup: " + meetup.toString());
        long res = meetupService.create(meetup);
        log.log(Level.INFO, "@@ Added id: " + res);

        return new ModelAndView("result", "meetup", meetup);
    }
}
