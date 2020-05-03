// Fig. 30.7: SessionBean1.java
// Session bean initializes the data source for the 
// AddressBook database.
package addressbook;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.sql.rowset.CachedRowSetXImpl;
import javax.faces.FacesException;

public class SessionBean1 extends AbstractSessionBean
{
   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
      addressesRowSet.setDataSourceName( 
         "java:comp/env/jdbc/TEST_ApacheDerby" );
      addressesRowSet.setCommand( 
         "SELECT ALL " + 
            "TEST.ADDRESSES.FIRSTNAME, " + 
            "TEST.ADDRESSES.LASTNAME, " + 
            "TEST.ADDRESSES.STREET, " + 
            "TEST.ADDRESSES.CITY, " + 
            "TEST.ADDRESSES.STATE, " + 
            "TEST.ADDRESSES.ZIP " + 
            "FROM TEST.ADDRESSES " + 
         "ORDER BY TEST.ADDRESSES.LASTNAME ASC, " + 
            "TEST.ADDRESSES.FIRSTNAME ASC" );        
      addressesRowSet.setTableName( "ADDRESSES" );
   } // end method _init
   
   private CachedRowSetXImpl addressesRowSet = new CachedRowSetXImpl();

   public CachedRowSetXImpl getAddressesRowSet()
   {
      return addressesRowSet;
   } // end method getAddressesRowSet

   public void setAddressesRowSet( CachedRowSetXImpl crsxi )
   {
      this.addressesRowSet = crsxi;
   } // end method setAddressesRowSet
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
} // end class SessionBean1


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
