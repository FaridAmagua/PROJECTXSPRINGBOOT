package proyectox.proyectoxcorp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyectox.proyectoxcorp.entity.Contact;
import proyectox.proyectoxcorp.service.ContactService;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContactDto {
    private String name;
    private String email;
}
