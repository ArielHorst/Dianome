package com.dianome.app.repositories;

import com.dianome.app.models.ReclamacaoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ReclamacaoRepository extends CrudRepository<ReclamacaoModel, Long> {
}
