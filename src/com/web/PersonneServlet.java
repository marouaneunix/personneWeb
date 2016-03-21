package com.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejbs.PersonneBeanLocal;

import model.Personne;

/**
 * Servlet implementation class PersonneServlet
 */
@WebServlet( "*.do" )
public class PersonneServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String PERSONNE_VAR     = "personnes";
    private static final String PERSONNE_PAGE    = "/WEB-INF/personne.jsp";
    private static final String PARAM_ACTION     = "action";
    private static final String PARAM_PERSONNE   = "nomPersonne";
    private static final String PRAMA_ID         = "nom";

    public PersonneServlet() {
        super();
    }

    @EJB
    PersonneBeanLocal pb;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String action = request.getParameter( PARAM_ACTION );
        String nom = request.getParameter( PRAMA_ID );

        if ( action != null && nom != null ) {
            if ( action.equals( "del" ) ) {
                pb.deletePersonne( nom );
            }
        }

        ArrayList<Personne> personnes = (ArrayList<Personne>) pb.getAllPersonne();
        request.setAttribute( PERSONNE_VAR, personnes );
        request.getRequestDispatcher( PERSONNE_PAGE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String action = request.getParameter( PARAM_ACTION );
        String nomPersonne = request.getParameter( PARAM_PERSONNE );
        String nom = request.getParameter( PRAMA_ID );

        if ( action.equals( "Save" ) && nomPersonne != null ) {
            Personne p = new Personne();
            p.setNom( nomPersonne );
            pb.addPersonne( p );
        } else if ( action.equals( "Update" ) && nom != null && nomPersonne != null ) {
            // pb.deletePersonne( nom );
            // Personne per = new Personne();
            // per.setNom( nom );
            // pb.updatePersonne( per, nomPersonne );

            pb.updatePersonneV3( nom, nomPersonne );

        }

        ArrayList<Personne> personnes = (ArrayList<Personne>) pb.getAllPersonne();
        request.setAttribute( PERSONNE_VAR, personnes );
        request.getRequestDispatcher( PERSONNE_PAGE ).forward( request, response );

    }

}
