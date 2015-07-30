package interceptor;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.UsuarioService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UsuarioService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String login = auth.getName();
            usuario = service.findByLogin(login);
            session.setAttribute("usuario", usuario);
        }

        return super.preHandle(request, response, handler);
    }
}
