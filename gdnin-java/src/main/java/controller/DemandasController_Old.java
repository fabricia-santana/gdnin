package controller;

import model.Demanda;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import service.DemandaService;
import vo.DemandasListVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//@Controller
//@RequestMapping(value = "/protected/demandas")
public class DemandasController_Old {

    private static final String DEFAULT_PAGE_DISPLAYED_TO_USER = "0";

    @Autowired
    private DemandaService service;

    @Autowired
    private MessageSource messageSource;

    @Value("5")
    private int maxResults;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("demandasList");
    }

//    @RequestMapping(method=RequestMethod.GET, produces = "application/json")
//    @ResponseBody 
//    public Demanda listar(@RequestParam int page, Locale locale) {
////        return criarLista(page, locale, null);
//    	return service.findAll(page, maxResults);
//    }
//    
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<?> listar(@RequestParam int page, Locale locale) {
//        return criarLista(page, locale, null);
//    }

//    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
//    public ResponseEntity<?> create(@ModelAttribute("contact") Demanda contact,
//                                    @RequestParam(required = false) String searchFor,
//                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
//                                    Locale locale) {
//       // contactService.save(contact);
//
//        if (isSearchActivated(searchFor)) {
//            return search(searchFor, page, locale, "message.create.success");
//        }
//
//        //return criarLista(page, locale, "message.create.success");
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("id") int contactId,
                                    @RequestBody Demanda contact,
                                    @RequestParam(required = false) String searchFor,
                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
                                    Locale locale) {
        if (contactId != contact.getId()) {
            return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
        }

       //contactService.save(contact);

        if (isSearchActivated(searchFor)) {
            return search(searchFor, page, locale, "message.update.success");
        }

        return null;
        		//criarLista(page, locale, "message.update.success");
    }

    @RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> delete(@PathVariable("contactId") int contactId,
                                    @RequestParam(required = false) String searchFor,
                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
                                    Locale locale) {


//        try {
//            contactService.delete(contactId);
//        } catch (AccessDeniedException e) {
//            return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
//        }

        if (isSearchActivated(searchFor)) {
            return search(searchFor, page, locale, "message.delete.success");
        }

        return null;
        		//criarLista(page, locale, "message.delete.success");
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> search(@PathVariable("name") String name,
                                    @RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER) int page,
                                    Locale locale) {
        return search(name, page, locale, null);
    }

    private ResponseEntity<?> search(String name, int page, Locale locale, String actionMessageKey) {
        //ContactListVO contactListVO = contactService.findByNameLike(page, maxResults, name);

        if (!StringUtils.isEmpty(actionMessageKey)) {
           // addActionMessageToVO(contactListVO, locale, actionMessageKey, null);
        }

        Object[] args = {name};

       // addSearchMessageToVO(contactListVO, locale, "message.search.for.active", args);

        return  null;
        		//ResponseEntity<ContactListVO>(contactListVO, HttpStatus.OK);
    }

    private ResponseEntity<DemandasListVO> returnListToUser(DemandasListVO contactList) {
        return new ResponseEntity<DemandasListVO>(contactList, HttpStatus.OK);
    }
    
//    private List<DemandasListVO> criarLista(int page, Locale locale, String menssagem) {
//    	DemandasListVO demandasListVO = service.findAll(page, maxResults);
//    	List<DemandasListVO> list = new ArrayList<DemandasListVO>();
//    	list.add(demandasListVO);
//    	
//    	return list;
//    	
////    	addActionMessageToVO(demandasListVO, locale, menssagem, null);
////    	
////    	return returnListToUser(demandasListVO);
//    }

//    private ResponseEntity<?> criarLista(int page, Locale locale, String menssagem) {
//    	DemandasListVO demandasListVO = service.findAll(page, maxResults);
//    	
//    	addActionMessageToVO(demandasListVO, locale, menssagem, null);
//    	
//    	return returnListToUser(demandasListVO);
//    }

    private DemandasListVO addActionMessageToVO(DemandasListVO contactListVO, Locale locale, String actionMessageKey, Object[] args) {
        if (StringUtils.isEmpty(actionMessageKey)) {
            return contactListVO;
        }

        contactListVO.setActionMessage(messageSource.getMessage(actionMessageKey, args, null, locale));

        return contactListVO;
    }

    private DemandasListVO addSearchMessageToVO(DemandasListVO contactListVO, Locale locale, String actionMessageKey, Object[] args) {
        if (StringUtils.isEmpty(actionMessageKey)) {
            return contactListVO;
        }

        contactListVO.setSearchMessage(messageSource.getMessage(actionMessageKey, args, null, locale));

        return contactListVO;
    }

    private boolean isSearchActivated(String searchFor) {
        return !StringUtils.isEmpty(searchFor);
    }
}