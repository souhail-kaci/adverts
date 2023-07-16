package fr.souhail.adverts.repositories;

import fr.souhail.adverts.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdvertRepository extends JpaRepository<Advert,Integer> {
}
