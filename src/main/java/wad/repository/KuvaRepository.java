package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Kuva;
import wad.domain.Uutinen;

public interface KuvaRepository extends JpaRepository<Kuva, Long> {
    Kuva findByUutinen(Uutinen uutinen);
}
