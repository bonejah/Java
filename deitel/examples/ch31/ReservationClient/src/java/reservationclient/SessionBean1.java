package reservationclient;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import javax.faces.FacesException;

public class SessionBean1 extends AbstractSessionBean
{
   private String seatType;
   private String classType;

   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   /**
    * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
    * This method is automatically generated, so any user-specified code inserted
    * here is subject to being replaced.</p>
    */
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
         throw e instanceof FacesException ? (FacesException) e : new FacesException( e );
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
      return (ApplicationBean1) getBean( "ApplicationBean1" );
   }

   // return the seatType
   public String getSeatType()
   {
      return seatType;
   } // end method getSeatType

   // set the seatType
   public void setSeatType( String seatType )
   {
      this.seatType = seatType;
   } // end method setSeatType

   // return the classType
   public String getClassType()
   {
      return classType;
   } // end method getClassType

   // set the classType
   public void setClassType( String classType )
   {
      this.classType = classType;
   } // end method setClassType
} // end class SessionBean1

/**************************************************************************
 * (C) Copyright 1992-2009 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/


