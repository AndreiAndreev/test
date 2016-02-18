package com.andrei.test.controller;

/**
 * Created by totzh on 24.01.2016.
 */

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import com.andrei.test.domain.Person;
import com.andrei.test.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "personService")
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model){
        logger.debug("Pokaz vseh chelovekov!");

        List<Person> persons = personService.getAll();

        model.addAttribute("persons", persons);

        return "personspage";
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.debug("Zapros na stranicu dobavlenia");

        model.addAttribute("personAttribute", new Person());

        return "addpage";
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Person person){
        logger.debug("Zapros na dobavlenie cheloveka");

        personService.add(person);

        return "addedpage";
    }

    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) Integer id, Model model){
        logger.debug("Получен запрос на удаление человека");

        personService.delete(id);

        model.addAttribute("id", id);

        return "deletedpage";
    }

    @RequestMapping(value = "/persons/search", method = RequestMethod.GET)
    public String getSearch(Model model){
        logger.debug("Poluchen zapros na stranicu poiska cheloveka");

        model.addAttribute("personAttribute", new Person());

        return "searchpage";
    }

    @RequestMapping(value = "/persons/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("personAttribute") Person person, Model model) {
        logger.debug("Zapros na poisk cheloveka");

        Person person1 = personService.get(person.getId());

        model.addAttribute("person", person1);

        return "searchedpage";
    }


    @RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) Integer id, Model model){
        logger.debug("Zapros na pokaz stranici redaktirovania");

        model.addAttribute("personAttribute", personService.get(id));

        return "editpage";
    }

    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person,
                           @RequestParam(value="id", required=true) Integer id,
                           Model model){
        logger.debug("Zapros na redaktirovanie cheloveka");

        person.setId(id);

        personService.edit(person);

        model.addAttribute("id", id);

        return "editedpage";
    }


}
