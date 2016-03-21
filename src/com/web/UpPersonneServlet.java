package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpPersonneServlet
 */
@WebServlet( "*.up" )
public class UpPersonneServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    // private static final String PERSONNE_PAGE = "/WEB-INF/personne.jsp";
    private static final String PERSONNE_UP_PAGE = "/WEB-INF/upPersonne.jsp";
    private static final String PARAM_NOM        = "nom";
    private static final String PARAM_PERSONNE   = "nomPersonne";
    private static final String PARAM_ACTION     = "action";

    public UpPersonneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String nom = request.getParameter( PARAM_NOM );
        String action = request.getParameter( PARAM_ACTION );

        if ( nom != null && action != null ) {
            request.setAttribute( PARAM_PERSONNE, nom );
        }

        request.getRequestDispatcher( PERSONNE_UP_PAGE ).forward( request, response );

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
