package com.springboot.listCrudOpgave;

import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ContactService;
import utility.Message;

import java.util.Locale;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/list")
    public String listContacts(Model model) {
        model.addAttribute("contactList", contactService.findAll());
        return "contacts/list";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable long id, Model model) {

        Contact contact = contactService.findById(id);
        if (contact == null) {
            return "redirect:/contacts/list";
        }
        model.addAttribute("contact", contact);
        return "contacts/show";
    }


    @GetMapping(value = "/edit/{id}")
    public String updateForm(@PathVariable long id, Model model) {

        Contact contact = contactService.findById(id);
        if (contact == null) {
            return "redirect:/contacts/list";
        }
        model.addAttribute("contact", contact);
        return "/contacts/edit";
    }


    @PostMapping(value = "/edit/{id}")
    public String update(@PathVariable long id, Contact contact,
                         BindingResult bindingResult, Model model, Locale locale) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("contact_save_fail", new Object[]{}, locale)));

            return "contacts/edit";
        }

        contact.setId(id);
        contactService.save(contact);

        return "redirect:/contacts/list";
    }


}
