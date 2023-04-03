package com.seot.controllers.usuarios;

import com.seot.facade.UsuarioFacadeLocal;
import com.seot.modelos.entities.Usuario;
import java.io.IOException;
import jakarta.inject.Inject;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(filterName = "PreRecuperaFilter", urlPatterns = {"/usuarios/recuperacionclave/index"})

public class PreRecuperaFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Inject
    private UsuarioFacadeLocal uFacade;
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public PreRecuperaFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            String codigo = rq.getParameter("codigo");
            Usuario usuario = uFacade.find(id);
            if (usuario != null && codigo != null && codigo.trim().length() > 0) {
                //
                rq.getSession().setAttribute("codigoOk", usuario);
                rq.getRequestDispatcher("/usuarios/recuperacionclave/recupera.xhtml").forward(rq, rs);
            } else {
                rs.sendRedirect(rq.getContextPath());
            }
        } catch (Exception exception) {
            rs.sendRedirect(rq.getContextPath());
        }
    }

    @Override
    public void destroy() {
    }

}
