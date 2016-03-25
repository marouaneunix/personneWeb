package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpReclamation
 */
@WebServlet( "*.uprec" )
public class UpReclamationServlet extends HttpServlet {
    private static final long   serialVersionUID  = 1L;
    private static final String PERSONNE_UP_PAGE  = "/WEB-INF/upReclamation.jsp";
    private static final String PARAM_ID          = "id";
    private static final String PARAM_ACTION      = "action";
    private static final String PARAM_COMMENTAIRE = "commentaire";
    private static final String PARAM_NOM         = "nomPersonne";

    public UpReclamationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String id = request.getParameter( PARAM_ID );
        String action = request.getParameter( PARAM_ACTION );
        String nom = request.getParameter( PARAM_NOM );
        String commentaire = request.getParameter( PARAM_COMMENTAIRE );

        if ( nom != null && action != null && id != null ) {
            request.setAttribute( PARAM_ID, id );
            request.setAttribute( PARAM_NOM, nom );
            request.setAttribute( PARAM_COMMENTAIRE, commentaire );
        }
        request.getRequestDispatcher( PERSONNE_UP_PAGE ).forward( request, response );

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        doGet( request, response );
    }

}
