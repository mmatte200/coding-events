package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static final List<String> events = new ArrayList<>();

    // handles GET requests at /events
    // the root controller method for this class
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        model.addAttribute("title", "All Events");
        return "events/index";
    }

    // responds to GET requests at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create New Event");
        return "events/create";
    }

    // responds to POST requests at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String newEvent) {

        // "store" the new event
        events.add(newEvent);

        // send them back to the main event listing
        // equivalent of sending 302 HTTP response code with Location=/events
        return "redirect:";
    }

}
