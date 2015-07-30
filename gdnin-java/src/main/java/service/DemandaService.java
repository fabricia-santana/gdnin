package service;

import model.Demanda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.DemandaRepository;
import vo.DemandasListVO;

@Service
@Transactional
public class DemandaService {

    @Autowired
    private DemandaRepository repository;

    @Transactional(readOnly = true)
    public ResponseEntity<DemandasListVO> getListaDemandas(int pagina, int maxResults) {
        Page<Demanda> result = executaListaDemandas(pagina, maxResults);

        if(isUltimaPagina(pagina, result)){
            int ultimaPagina= result.getTotalPages() - 1;
            result = executaListaDemandas(ultimaPagina, maxResults);
        }

        return criarEntity(result);
    }
    
    private ResponseEntity<DemandasListVO> criarEntity(Page<Demanda> result) {
    	DemandasListVO listaDemandas = new DemandasListVO(result.getTotalPages(), result.getTotalElements(), result.getContent());
    	return new ResponseEntity<DemandasListVO>(listaDemandas, HttpStatus.OK);
    }
//
//    public void save(Demanda contact) {
//        contactRepository.save(contact);
//    }
//
//    @Secured("ROLE_ADMIN")
//    public void delete(int contactId) {
//        contactRepository.delete(contactId);
//    }
//
//    @Transactional(readOnly = true)
//    public ContactListVO findByNameLike(int page, int maxResults, String name) {
//        Page<Demanda> result = executeQueryFindByName(page, maxResults, name);
//
//        if(isUltimaPagina(page, result)){
//            int lastPage = result.getTotalPages() - 1;
//            result = executeQueryFindByName(lastPage, maxResults, name);
//        }
//
//        return buildResult(result);
//    }
//
    private boolean isUltimaPagina(int page, Page<Demanda> result) {
        return page >= result.getTotalPages() - 1 && result.getTotalElements() > 0;
    }

    private Page<Demanda> executaListaDemandas(int page, int maxResults) {
    	
        final PageRequest pageRequest = new PageRequest(page, maxResults, sortByNumControleASC());
        
        Page<Demanda> pageDemanda = repository.findByTipoDemandaId(pageRequest, 1);
        
        return pageDemanda;
    }

    private Sort sortByNumControleASC() {
        return new Sort(Sort.Direction.ASC, "numControle");
    }

   
//
//    private Page<Demanda> executeQueryFindByName(int page, int maxResults, String name) {
//        final PageRequest pageRequest = new PageRequest(page, maxResults, sortByNumControleASC());
//
//        return contactRepository.findByDescricaoLike(pageRequest, "%" + name + "%");
//    }
//

}