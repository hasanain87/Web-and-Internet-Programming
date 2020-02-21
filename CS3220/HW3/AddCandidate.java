package CandidateRating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

    public AddCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	request.getRequestDispatcher("/WEB-INF/addCandidate.jsp").forward(request, response);

		
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter( "name" );
		String spec=request.getParameter( "specialties" );
		String pres=request.getParameter( "presentation" );
		
		
		if(name.trim().length()==0||spec.trim().length()==0||pres.trim().length()==0) {
			
			response.sendRedirect( "AddCandidate" );
		   return;
			
		}
		
		
		System.out.println(" candidateName "+name);
		System.out.println(" Specia "+spec);
		System.out.println(" Present "+pres);
		
		
   // get the refrence to ArrayList from Application Scope	
  ArrayList <CandidateRating> candidates =(ArrayList <CandidateRating>) getServletContext().getAttribute("candidates");
		
		
	    //
        candidates.add(new CandidateRating(name,spec,pres));
        
        // request to Controller serverlet
		response.sendRedirect( "CandidadatesServ" );	
		
	}

}
