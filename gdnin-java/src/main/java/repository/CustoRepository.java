package repository;

import java.util.List;

import model.Custo;

import org.springframework.data.repository.CrudRepository;

public interface CustoRepository extends CrudRepository<Custo, Integer> {
	
	List<Custo> findByDemandaId(Integer demandaId);
	
	//Float getTotalCustos

}
