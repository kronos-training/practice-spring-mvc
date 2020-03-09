package com.vanessapr.practica03.springmvc.controllers;

import com.vanessapr.practica03.springmvc.beans.Client;
import com.vanessapr.practica03.springmvc.services.ClientService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController {
    public final static Logger logger = Logger.getLogger(ClientController.class);
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Clients");
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("client", new Client());

        return "index";
    }

    @PostMapping("/create")
    public String create(Client client) {
        if (clientService.find(client.getId()) != null) {
            clientService.update(client);
        } else {
            clientService.save(client);
        }

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("titulo", "Clients");
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("client", clientService.find(id));

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        clientService.remove(id);

        return "redirect:/";
    }

    @GetMapping("/export/{format}")
    public String exportReport(@PathVariable("format") String format, Model model) throws Exception {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);

        if (format.equals("pdf")) {
            return "pdfView";
        } else if (format.equals("excel")) {
            return "excelView";
        } else {
            throw new Exception("Format does not exist");
        }
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerGenericException(Exception e, Model model) {
        model.addAttribute("exception", e);
        return new ModelAndView("error");
    }
}
