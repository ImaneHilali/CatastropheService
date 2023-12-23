package ma.fstt.map.repo;

import ma.fstt.map.model.Catastrophe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatastropheRepo extends JpaRepository<Catastrophe, Long> {
}
