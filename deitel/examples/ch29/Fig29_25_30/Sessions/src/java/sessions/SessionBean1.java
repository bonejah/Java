// Fig. 29.27: SessionBean1.java
// SessionBean file for storing language selections.
package sessions;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.HashMap;
import javax.faces.FacesException;

public class SessionBean1 extends AbstractSessionBean
{
   private int numberOfSelections; // stores number of languages selected

   // stores HashMap containing user's selections
   private HashMap<String, String> selections = 
      new HashMap<String, String>();                  
   
   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
   }
   // </editor-fold>
   
   public SessionBean1()
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
         log( "SessionBean1 Initialization Failure", e );
         throw e instanceof FacesException ? ( FacesException ) e : 
            new FacesException( e );
      }

   // </editor-fold>
   }

   @Override
   public void passivate()
   {
   }

   @Override
   public void activate()
   {
   }

   @Override
   public void destroy()
   {
   }

   protected ApplicationBean1 getApplicationBean1()
   {
      return ( ApplicationBean1 ) getBean( "ApplicationBean1" );
   }
   
   public int getNumberOfSelections()
   {
      return numberOfSelections;
   } // end method getNumberOfSelections

   public void setNumberOfSelections( int numberOfSelections )
   {
      this.numberOfSelections = numberOfSelections;
   } // end method setNumberOfSelections

   public HashMap<String, String> getSelectedLanguages()
   {
      return selections;
   } // end method getSelectedLanguages

   public void setSelectedLanguages( HashMap<String, String> selections )
   {
      this.selections = selections;
   } // end method setSelectedLanguages
} // end class SessionBean1
