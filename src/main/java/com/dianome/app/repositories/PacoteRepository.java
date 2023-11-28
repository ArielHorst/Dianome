package com.dianome.app.repositories;

import com.dianome.app.models.PacoteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PacoteRepository extends CrudRepository<PacoteModel, Long> {
}
