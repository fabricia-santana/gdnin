package repository;

import model.Demanda;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DemandaRepository extends PagingAndSortingRepository<Demanda, Integer> {
	
    Page<Demanda> findByTipoDemandaId(Pageable pageable, Integer IdTipoDemanda);
}