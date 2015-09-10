package repository;

import java.util.List;

import model.HoraTrabalhada;

import org.springframework.data.repository.CrudRepository;

public interface HoraTrabalhadaRepository extends CrudRepository<HoraTrabalhada, Integer> {

	List<HoraTrabalhada> findByDemandaIdOrderByMesAnoDesc(Integer idDemanda);
}
