// Fig. 30.8: AddressBook.java
// Page bean for adding a contact to the address book.
package addressbook;

import com.sun.data.provider.RowKey;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;

public class AddressBook extends AbstractPageBean
{
   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
      addressesTable.setInternalVirtualForm( true );
      addressesDataProvider.setCachedRowSet( 
         ( javax.sql.rowset.CachedRowSet ) getValue( 
            "#{SessionBean1.addressesRowSet}" ) );
   } // end method _init
   
   private Table addressesTable = new Table();

   public Table getAddressesTable()
   {
      return addressesTable;
   } // end method getAddressesTable

   public void setAddressesTable( Table t )
   {
      this.addressesTable = t;
   } // end method setAddressesTable
   
   private CachedRowSetDataProvider addressesDataProvider = 
      new CachedRowSetDataProvider();

   public CachedRowSetDataProvider getAddressesDataProvider()
   {
      return addressesDataProvider;
   } // end method getAddressesDataProvider

   public void setAddressesDataProvider( CachedRowSetDataProvider crsdp )
   {
      this.addressesDataProvider = crsdp;
   } // end method setAddressesDataProvider
   
   private TextField firstNameTextField = new TextField();

   public TextField getFirstNameTextField()
   {
      return firstNameTextField;
   }

   public void setFirstNameTextField( TextField tf )
   {
      this.firstNameTextField = tf;
   }
   
   private TextField lastNameTextField = new TextField();

   public TextField getLastNameTextField()
   {
      return lastNameTextField;
   }

   public void setLastNameTextField( TextField tf )
   {
      this.lastNameTextField = tf;
   }
   
   private TextField streetTextField = new TextField();

   public TextField getStreetTextField()
   {
      return streetTextField;
   }

   public void setStreetTextField( TextField tf )
   {
      this.streetTextField = tf;
   }
   
   private TextField cityTextField = new TextField();

   public TextField getCityTextField()
   {
      return cityTextField;
   }

   public void setCityTextField( TextField tf )
   {
      this.cityTextField = tf;
   }
   
   private TextField stateTextField = new TextField();

   public TextField getStateTextField()
   {
      return stateTextField;
   }

   public void setStateTextField( TextField tf )
   {
      this.stateTextField = tf;
   }
   
   private TextField zipTextField = new TextField();

   public TextField getZipTextField()
   {
      return zipTextField;
   }

   public void setZipTextField( TextField tf )
   {
      this.zipTextField = tf;
   }

   // </editor-fold>
   public AddressBook()
   {
   }

   @Override
   public void init()
   {
      // Perform initializations inherited from our superclass
      super.init();

      // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
      try
      {
         _init();
      } 
      catch ( Exception e )
      {
         log( "Page1 Initialization Failure", e );
         throw e instanceof FacesException ? ( FacesException ) e : 
            new FacesException( e );
      }
   // </editor-fold>
   }

   @Override
   public void preprocess()
   {
   }

   @Override
   public void prerender()
   {
      addressesDataProvider.refresh();
   } // end method prerender

   @Override
   public void destroy()
   {
      addressesDataProvider.close();
   } // end method destroy

   protected SessionBean1 getSessionBean1()
   {
      return ( SessionBean1 ) getBean( "SessionBean1" );
   }

   protected RequestBean1 getRequestBean1()
   {
      return ( RequestBean1 ) getBean( "RequestBean1" );
   }

   protected ApplicationBean1 getApplicationBean1()
   {
      return ( ApplicationBean1 ) getBean( "ApplicationBean1" );
   }

   // action handler that adds a contact to the AddressBook 
   // database when the user clicks submit
   public String submitButton_action()
   {
      // check whether a row can be appended
      if ( addressesDataProvider.canAppendRow() )
      {
         try
         {
            // append new row and move cursor to that row
            RowKey rk = addressesDataProvider.appendRow();
            addressesDataProvider.setCursorRow( rk );

            // set values for the new row's columns
            addressesDataProvider.setValue( "ADDRESSES.FIRSTNAME",
               firstNameTextField.getValue() );
            addressesDataProvider.setValue( "ADDRESSES.LASTNAME",
               lastNameTextField.getValue() );
            addressesDataProvider.setValue( "ADDRESSES.STREET",
               streetTextField.getValue() );
            addressesDataProvider.setValue( "ADDRESSES.CITY",
               cityTextField.getValue() );
            addressesDataProvider.setValue( "ADDRESSES.STATE",
               stateTextField.getValue() );
            addressesDataProvider.setValue( "ADDRESSES.ZIP",
               zipTextField.getValue() );
            
            // commit the changes to the database
            addressesDataProvider.commitChanges();

            // reset text fields
            firstNameTextField.setValue( "" );
            lastNameTextField.setValue( "" );
            streetTextField.setValue( "" );
            cityTextField.setValue( "" );
            stateTextField.setValue( "" );
            zipTextField.setValue( "" );
         } // end try
         catch ( Exception ex )
         {
            error( "The address book was not updated. " +
               ex.getMessage() );
         } // end catch
      } // end if

      return null;
   } // end method submitButton_action
} // end class AddressBook


/*************************************************************************
 * (C) Copyright 1992-2009 by Deitel & Associates, Inc. and              *
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
