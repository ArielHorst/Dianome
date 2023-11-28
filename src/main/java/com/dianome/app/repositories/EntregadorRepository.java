package com.dianome.app.repositories;

import com.dianome.app.models.EntregadorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EntregadorRepository extends CrudRepository<EntregadorModel,Long> {
}
