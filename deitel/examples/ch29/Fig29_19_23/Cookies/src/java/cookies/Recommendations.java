// Fig. 29.23: Recommendations.java
// Displays book recommendations based on cookies that 
// contain the user's selected programming languages.
package cookies;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TextArea;
import javax.faces.FacesException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Recommendations extends AbstractPageBean
{
   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
   }
   private TextArea recommendationsTextArea = new TextArea();

   public TextArea getRecommendationsTextArea()
   {
      return recommendationsTextArea;
   }

   public void setRecommendationsTextArea( TextArea ta )
   {
      this.recommendationsTextArea = ta;
   }
   // </editor-fold>
   
   public Recommendations()
   {
   }

   @Override
   public void init()
   {
      // Perform initializations inherited from our superclass
      super.init();
      
      // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
      // Initialize automatically managed components
      // *Note* - this logic should NOT be modified
      try
      {
         _init();
      } 
      catch ( Exception e )
      {
         log( "Recommendations Initialization Failure", e );
         throw e instanceof FacesException ? ( FacesException ) e : 
            new FacesException( e );
      }

   // </editor-fold>
   }

   @Override
   public void preprocess()
   {
   }

   // process and display user's selections
   @Override
   public void prerender()
   {
      // retrieve cookies
      HttpServletRequest request =
         ( HttpServletRequest ) getExternalContext().getRequest();
      Cookie[] cookies = request.getCookies();

      // if there are cookies, store the corresponding 
      // books and ISBN numbers in a String
      String recommendations = "";

      if ( cookies.length > 1 )
      {
         for ( int i = 0; i < cookies.length - 1; i++ )
         {
            String language = cookies[ i ].getName().replace( '-', ' ' );
            
            // ignore cookie created when user returns to 
            // Options.jsp from Recommendations.jsp
            if ( !language.equals( "/Recommendations.jsp" ) )
               recommendations += language + " How to Program.  ISBN#: " +
                  cookies[ i ].getValue() + "\n";
         } // end for
      } // end if
      else
      {
         recommendations =
            "No recommendations. Please select a language.";
      } // end else

      recommendationsTextArea.setText( recommendations );
   } // end method prerender

   @Override
   public void destroy()
   {
   }

   protected ApplicationBean1 getApplicationBean1()
   {
      return ( ApplicationBean1 ) getBean( "ApplicationBean1" );
   }

   protected RequestBean1 getRequestBean1()
   {
      return ( RequestBean1 ) getBean( "RequestBean1" );
   }

   protected SessionBean1 getSessionBean1()
   {
      return ( SessionBean1 ) getBean( "SessionBean1" );
   }
} // end class Recommendations

/*************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and              *
 * Pearson Education, Inc. All Rights Reserved.                          *
 *                                                                       *
 * DISCLAIMER: The authors and publisher of this book have used their    *
 * best efforts in preparing the book. These efforts include the         *
 * development, research, and testing of the theories and programs       *
 * to determine their effectiveness. The authors and publisher make      *
 * no warranty of any kind, expressed or implied, with regard to these   *
 * programs or to the documentation contained in these books. The authors*
 * and publisher shall not be liable in any event for incidental or      *
 * consequential damages in connection with, or arising out of, the      *
 * furnishing, performance, or use of these programs.                    *
 ************************************************************************/

