package repository;

import java.util.List;

import model.Observacao;

import org.springframework.data.repository.CrudRepository;

public interface ObservacaoRepository extends CrudRepository<Observacao, Integer> {
	
	List<Observacao> findByDemandaIdOrderByDataCriacaoDesc(Integer idDemanda);
}
