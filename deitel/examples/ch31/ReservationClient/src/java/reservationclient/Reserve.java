// Fig. 23.18: Reserve.java
// Page bean for seat reservation client.
package reservationclient;

import com.deitel.java.reservation.Reservation;
import com.deitel.java.reservation.ReservationService;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;

public class Reserve extends AbstractPageBean
{
   // references the service endpoint interface object (i.e., the proxy)
   private Reservation reservationServiceProxy; // reference to proxy

   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
      seatTypeDropDownDefaultOptions.setOptions(
         new com.sun.webui.jsf.model.Option[]
         {
            new com.sun.webui.jsf.model.Option( "Aisle", "Aisle" ), 
            new com.sun.webui.jsf.model.Option( "Middle", "Middle" ),
            new com.sun.webui.jsf.model.Option( "Window", "Window" )
         }
      );
      classTypeDropDownDefaultOptions.setOptions(
         new com.sun.webui.jsf.model.Option[]
         {
            new com.sun.webui.jsf.model.Option( "Economy", "Economy" ),
            new com.sun.webui.jsf.model.Option( "First", "First" )
         }
      );

      // get service endpoint interface
      ReservationService reservationService = new ReservationService();
      reservationServiceProxy = reservationService.getReservationPort();
   } // end method _init

   private SingleSelectOptionsList seatTypeDropDownDefaultOptions = new SingleSelectOptionsList();

   public SingleSelectOptionsList getSeatTypeDropDownDefaultOptions()
   {
      return seatTypeDropDownDefaultOptions;
   }

   public void setSeatTypeDropDownDefaultOptions( SingleSelectOptionsList ssol )
   {
      this.seatTypeDropDownDefaultOptions = ssol;
   }

   private SingleSelectOptionsList classTypeDropDownDefaultOptions = new SingleSelectOptionsList();

   public SingleSelectOptionsList getClassTypeDropDownDefaultOptions()
   {
      return classTypeDropDownDefaultOptions;
   }

   public void setClassTypeDropDownDefaultOptions( SingleSelectOptionsList ssol )
   {
      this.classTypeDropDownDefaultOptions = ssol;
   }

   private DropDown seatTypeDropDown = new DropDown();

   public DropDown getSeatTypeDropDown()
   {
      return seatTypeDropDown;
   }

   public void setSeatTypeDropDown( DropDown dd )
   {
      this.seatTypeDropDown = dd;
   }

   private DropDown classTypeDropDown = new DropDown();

   public DropDown getClassTypeDropDown()
   {
      return classTypeDropDown;
   }

   public void setClassTypeDropDown( DropDown dd )
   {
      this.classTypeDropDown = dd;
   }

   private Label instructionLabel = new Label();

   public Label getInstructionLabel()
   {
      return instructionLabel;
   }

   public void setInstructionLabel( Label l )
   {
      this.instructionLabel = l;
   }

   private Button reserveButton = new Button();

   public Button getReserveButton()
   {
      return reserveButton;
   }

   public void setReserveButton( Button b )
   {
      this.reserveButton = b;
   }

   private Label successLabel = new Label();

   public Label getSuccessLabel()
   {
      return successLabel;
   }

   public void setSuccessLabel( Label l )
   {
      this.successLabel = l;
   }

   private Label errorLabel = new Label();

   public Label getErrorLabel()
   {
      return errorLabel;
   }

   public void setErrorLabel( Label l )
   {
      this.errorLabel = l;
   }

   // </editor-fold>
   public Reserve()
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
         log( "Page1 Initialization Failure", e );
         throw e instanceof FacesException ? (FacesException) e :
            new FacesException( e );
      }

   // </editor-fold>
   } // end method init

   @Override
   public void preprocess()
   {
   }

   @Override
   public void prerender()
   {
   }

   @Override
   public void destroy()
   {
   }

   protected SessionBean1 getSessionBean1()
   {
      return (SessionBean1) getBean( "SessionBean1" );
   }

   protected RequestBean1 getRequestBean1()
   {
      return (RequestBean1) getBean( "RequestBean1" );
   }

   protected ApplicationBean1 getApplicationBean1()
   {
      return (ApplicationBean1) getBean( "ApplicationBean1" );
   }

   // store selected seat type in session bean
   public void seatTypeDropDown_processValueChange(
      ValueChangeEvent event )
   {
      getSessionBean1().setSeatType(
         ( String ) seatTypeDropDown.getSelected() );
   } // end method seatTypeDropDown_processValueChange

   // store selected class in session bean
   public void classTypeDropDown_processValueChange(
      ValueChangeEvent event )
   {
      getSessionBean1().setClassType(
         ( String ) classTypeDropDown.getSelected() );
   } // end method classTypeDropDown_processValueChange

   // invoke the web service when the user clicks Reserve button
   public String reserveButton_action()
   {
      try
      {
         boolean reserved = reservationServiceProxy.reserve(
            getSessionBean1().getSeatType(),
            getSessionBean1().getClassType() );

         if ( reserved ) // display successLabel; hide all others
         {
            instructionLabel.setRendered( false );
            seatTypeDropDown.setRendered( false );
            classTypeDropDown.setRendered( false );
            reserveButton.setRendered( false );
            successLabel.setRendered( true );
            errorLabel.setRendered( false );
         } // end if
         else  // display all but successLabel
         {
            instructionLabel.setRendered( true );
            seatTypeDropDown.setRendered( true );
            classTypeDropDown.setRendered( true );
            reserveButton.setRendered( true );
            successLabel.setRendered( false );
            errorLabel.setRendered( true );
         } // end else
      } // end try
      catch ( Exception e )
      {
         e.printStackTrace();
      } // end catch

      return null;
   } // end method reserveButton_action
} // end class Reserve


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

