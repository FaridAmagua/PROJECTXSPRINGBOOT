package proyectox.proyectoxcorp.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import proyectox.proyectoxcorp.dto.ContactDto;
import proyectox.proyectoxcorp.entity.Contact;
import proyectox.proyectoxcorp.exception.ResourceNotFoundException;
import proyectox.proyectoxcorp.repository.ContactRepository;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll(){
        return  contactRepository.findAll();
    }

    public Contact findById( Integer id){
        return contactRepository.
                findById(id).
                orElseThrow(ResourceNotFoundException::new);

    }

    public Contact create( ContactDto contactDto){


        Contact contact = mapper.map(contactDto,Contact.class); //mapeo de Contact contact =  new Contact;

        contact.setCreatedAt(LocalDateTime.now());

        return contactRepository.save(contact);
    }
    public Contact update( Integer id, ContactDto contactDto){
        Contact contactFromDb = findById(id);
        mapper.map(contactDto,contactFromDb);
        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id){
        Contact contactFromDb=contactRepository.findById(id).orElse(null);
        contactRepository.delete(contactFromDb);

    }

}
