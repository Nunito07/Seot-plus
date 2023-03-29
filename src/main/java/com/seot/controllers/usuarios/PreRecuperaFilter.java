package com.seot.controllers.usuarios;

import com.seot.facade.UsuarioFacade;
import com.seot.facade.UsuarioFacadeLocal;
import com.seot.modelos.entities.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            int id = Integer.valueOf(rq.getParameter("id"));
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
