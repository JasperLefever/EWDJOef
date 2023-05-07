package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import domain.Contact;

public class ContactServiceImpl implements ContactService {

    private static List<Contact> list = new ArrayList<>();
    
    static {
    	
    	list.add(new Contact(1L, 1, "firstName1", "lastName1", "description1", LocalDate.now()));
        list.add(new Contact(2L, 2, "firstName2", "lastName2", "description2", LocalDate.now()));
        list.add(new Contact(3L, 3, "firstName3", "lastName3", "description3", LocalDate.now()));
        list.add(new Contact(4L, 4, "firstName4", "lastName4", "description4", LocalDate.now()));
        list.add(new Contact(5L, 5, "firstName5", "lastName5", "description5", LocalDate.now()));
        list.add(new Contact(6L, 6, "firstName6", "lastName6", "description6", LocalDate.now()));
        list.add(new Contact(7L, 7, "firstName7", "lastName7", "description7", LocalDate.now()));
        list.add(new Contact(8L, 81, "firstName8", "lastName8", "description8", LocalDate.now()));
    }

    @Override
    public List<Contact> findAll() {
        return list;
    }

    @Override
    public Contact findById(Long id) {
        return list.stream().filter(c -> id.compareTo(c.getId()) == 0).findFirst().orElse(null);
    }

    @Override
    public Contact save(Contact contact) {  
    	   
       ListIterator<Contact> it = list.listIterator();
       boolean updated = false;
       while (it.hasNext()) {
            Contact c = it.next();
            if (contact.getId().compareTo(c.getId())==0) {
                it.set(contact);
                updated = true;
            }
        }
        if (!updated)
        {
        	list.add(contact);
        }
        return contact;
    }
}
