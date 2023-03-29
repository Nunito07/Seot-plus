package com.seot.controllers.usuarios;

import com.seot.controllers.RecuperarClave;
import com.seot.modelos.entities.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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

@WebFilter(filterName = "RecuperaFilter", urlPatterns = {"/usuarios/recuperacionclave/recupera.xhtml"})
public class RecuperaFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    @Inject
    private RecuperarClave rc;

    public RecuperaFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        System.out.println("ndsjanjdknasjkndjansjdnjakndna");
        System.out.println("Pasó por el filter Recupera");
        if (rc != null) {
            if (rq.getSession().getAttribute("codigoOk") != null && rq.getSession().getAttribute("codigoOk") instanceof Usuario) {

                rc.setCorreo(((Usuario) rq.getSession().getAttribute("codigoOk")).getUsuCorreoElectronico());
                chain.doFilter(request, response);
            } else {
                rs.sendRedirect(rq.getContextPath());
            }
        } else {
            rs.sendRedirect(rq.getContextPath());
        }
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

}
