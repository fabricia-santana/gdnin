package repository;

import java.util.List;

import model.Custo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustoRepository extends CrudRepository<Custo, Integer> {
	
	List<Custo> findByDemandaId(Integer demandaId);
	
	@Query("SELECT sum(c.custo) as total FROM Custo c WHERE c.demanda.id= :demandaId")
	Float getTotalCustosByDemandaId(@Param("demandaId") Integer demandaId);

}
