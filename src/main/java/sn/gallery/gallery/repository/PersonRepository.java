package sn.gallery.gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.gallery.gallery.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
