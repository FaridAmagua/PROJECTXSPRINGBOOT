package proyectox.proyectoxcorp.controller;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectox.proyectoxcorp.dto.ContactDto;
import proyectox.proyectoxcorp.entity.Contact;
import proyectox.proyectoxcorp.repository.ContactRepository;
import proyectox.proyectoxcorp.service.ContactService;

import java.time.LocalDateTime;
import java.time.LocalTime;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContacController {

    private final ContactService contactService;


    @GetMapping
    public Iterable<Contact>list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @PostMapping
    public Contact create(@RequestBody ContactDto contactDto){
        return contactService.create(contactDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                       @RequestBody ContactDto contactDto){
        return contactService.update(id, contactDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);
    }


}
