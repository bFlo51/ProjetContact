package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    Contact findById(Long id);
    List<Contact> findByNom(String nom);
}