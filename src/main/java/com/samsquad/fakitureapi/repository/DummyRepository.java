package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.PojaGenerated;
import com.samsquad.fakitureapi.repository.model.Dummy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@PojaGenerated
@Repository
public interface DummyRepository extends JpaRepository<Dummy, String> {

  @Override
  List<Dummy> findAll();
}
