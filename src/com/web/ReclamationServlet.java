package com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejbs.PersonneBeanLocal;
import com.ejbs.ReclamationBeanLocal;

import model.Personne;
import model.Reclamation;

/**
 * Servlet implementation class ReclamationServlet
 */
@WebServlet( "*.rec" )
public class ReclamationServlet extends HttpServlet {
    private static final long   serialVersionUID                = 1L;
    private static final String RECLAMATION_PAGE                = "/WEB-INF/reclamation.jsp";
    private static final String PARAM_PERSONNE                  = "personne";
    private static final String PARAM_RECLAMATIONS_BY_PERSONNES = "reclamations";
    private static final String PARAM_PERSONNES                 = "personnes";
    private static final String PARAM_ACTION                    = "action";
    private static final String COMMENTAIRE_PERS                = "commentaire";
    private static final String PARAM_ID                        = "id";
    private static final String PARAM_NOM_DELETE                = "nomPersonne";

    public ReclamationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @EJB
    ReclamationBeanLocal rb;
    @EJB
    PersonneBeanLocal    pb;

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String nomPersonne = request.getParameter( PARAM_PERSONNE );
        String action = request.getParameter( PARAM_ACTION );
        String idcommentaire = request.getParameter( PARAM_ID );
        String nomDelete = request.getParameter( PARAM_NOM_DELETE );

        Personne per = new Personne();
        List<Reclamation> reclamations = null;
        ArrayList<Personne> person = (ArrayList<Personne>) pb.getAllPersonne();

        if ( nomPersonne != null ) {
            per = pb.getPersonne( nomPersonne );
            if ( per != null )
                reclamations = rb.getAllReclamationByPersonne( per );
        }

        System.out.println( "before Outside del" );

        if ( action != null && idcommentaire != null && nomDelete != null ) {
            if ( action.equals( "del" ) ) {
                System.out.println( "Inside del" );
                // System.out.println( idcommentaire );
                // System.out.println( nomDelete );
                Personne pers = pb.getPersonne( nomDelete );
                // System.out.println( pers.getNom() );
                for ( Reclamation rec : pers.getReclamations() ) {
                    System.out.println( rec.getId() + " : " + rec.getCommentaire() );
                }
                Reclamation reclamation = rb.getReclamation( Integer.parseInt( idcommentaire ) );

                for ( int i = 0; i < pers.getReclamations().size(); i++ ) {
                    if ( pers.getReclamations().get( i ).getCommentaire().equals( reclamation.getCommentaire() ) ) {
                        pers.getReclamations().remove( i );
                        pb.updatePersonneV2( pers );
                        break;
                    }
                }
            }
        }

        System.out.println( "after Outside del" );

        request.setAttribute( PARAM_PERSONNES, person );
        request.setAttribute( PARAM_RECLAMATIONS_BY_PERSONNES, reclamations );
        request.setAttribute( PARAM_PERSONNE, nomPersonne );

        request.getRequestDispatcher( RECLAMATION_PAGE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String action = request.getParameter( PARAM_ACTION );
        String nomPersonne = request.getParameter( PARAM_PERSONNE );
        String commentaire = request.getParameter( COMMENTAIRE_PERS );
        String id = request.getParameter( PARAM_ID );

        if ( action.equals( "Save" ) && nomPersonne != null && commentaire != null ) {
            Reclamation reclamation = new Reclamation();
            reclamation.setCommentaire( commentaire );
            Personne per = pb.getPersonne( nomPersonne );
            reclamation.setPersonne( per );
            per.getReclamations().add( reclamation );
            pb.updatePersonneV2( per );
        } else if ( action.equals( "Update" ) && commentaire != null && id != null ) {
            Reclamation rec = new Reclamation();
            rec.setId( Integer.parseInt( id ) );
            rec.setCommentaire( commentaire );
            rb.updateReclamationV2( rec );
        }

        Personne pers = new Personne();
        List<Reclamation> reclamations = null;
        ArrayList<Personne> person = (ArrayList<Personne>) pb.getAllPersonne();

        if ( nomPersonne != null ) {
            pers = pb.getPersonne( nomPersonne );
            if ( pers != null )
                reclamations = rb.getAllReclamationByPersonne( pers );
        }

        request.setAttribute( PARAM_PERSONNES, person );
        request.setAttribute( PARAM_RECLAMATIONS_BY_PERSONNES, reclamations );
        request.setAttribute( PARAM_PERSONNE, nomPersonne );

        request.getRequestDispatcher( RECLAMATION_PAGE ).forward( request, response );

    }

}
