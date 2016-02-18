package com.andrei.test.service;

/**
 * Created by totzh on 24.01.2016.
 */

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.andrei.test.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
@Transactional
public class PersonService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Person> getAll(){
        logger.debug("Poluchaem vseh chelovekov!");

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM  Person");

        return query.list();
    }

    public Person get(Integer id){
        logger.debug("Poluchaem cheloveka po id");

        Session session = sessionFactory.getCurrentSession();

        Person person = (Person) session.get(Person.class, id);

        return person;
    }

    public void add(Person person){
        logger.debug("Dobavliaem cheloveka");

        Session session = sessionFactory.getCurrentSession();

        session.save(person);
    }

    public void delete(Integer id){
        logger.debug("Udaliaem cheloveka!");

        Session session = sessionFactory.getCurrentSession();

        Person person = (Person) session.get(Person.class, id);

        session.delete(person);
    }

    public void edit(Person person){
        logger.debug("Meniaem cheloveka!");

        Session session = sessionFactory.getCurrentSession();

        Person existingPerson = (Person) session.get(Person.class, person.getId());

        existingPerson.setAdmin(person.getAdmin());
        existingPerson.setAge(person.getAge());
        existingPerson.setName(person.getName());

        session.save(existingPerson);
    }


}
