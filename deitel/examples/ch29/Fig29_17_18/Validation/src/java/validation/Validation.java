// Fig. 29.18: Validation.java
// Validating user input.
package validation;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.ValidatorException;

public class Validation extends AbstractPageBean
{
   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
      nameLengthValidator.setMaximum( 30 );
   } // end method _init
   
   private TextField nameTextField = new TextField();

   public TextField getNameTextField()
   {
      return nameTextField;
   } // end method getNameTextField

   public void setNameTextField( TextField tf )
   {
      this.nameTextField = tf;
   } // end method setNameTextField
   
   private TextField emailTextField = new TextField();

   public TextField getEmailTextField()
   {
      return emailTextField;
   } // end method getEmailTextField

   public void setEmailTextField( TextField tf )
   {
      this.emailTextField = tf;
   } // end method setEmailTextField
   
   private TextField phoneTextField = new TextField();

   public TextField getPhoneTextField()
   {
      return phoneTextField;
   } // end method getPhoneTextField

   public void setPhoneTextField( TextField tf )
   {
      this.phoneTextField = tf;
   } // end method setPhoneTextField
   
   private StaticText resultText = new StaticText();

   public StaticText getResultText()
   {
      return resultText;
   } // end method getResultText

   public void setResultText( StaticText st )
   {
      this.resultText = st;
   } // end method getGridPanel
   
   private HtmlPanelGrid gridPanel = new HtmlPanelGrid();

   public HtmlPanelGrid getGridPanel()
   {
      return gridPanel;
   } // end method getGridPanel

   public void setGridPanel( HtmlPanelGrid hpg )
   {
      this.gridPanel = hpg;
   } // end method setGridPanel
   
   private StaticText nameValueText = new StaticText();

   public StaticText getNameValueText()
   {
      return nameValueText;
   } // end method getNameValueText

   public void setNameValueText( StaticText st )
   {
      this.nameValueText = st;
   } // end method setNameValueText
   
   private StaticText emailValueText = new StaticText();

   public StaticText getEmailValueText()
   {
      return emailValueText;
   } // end method getEmailValueText

   public void setEmailValueText( StaticText st )
   {
      this.emailValueText = st;
   } // end method setEmailValueText
   
   private StaticText phoneValueText = new StaticText();

   public StaticText getPhoneValueText()
   {
      return phoneValueText;
   } // end method getPhoneValueText

   public void setPhoneValueText( StaticText st )
   {
      this.phoneValueText = st;
   } // end method setPhoneValueText
   
   private LengthValidator nameLengthValidator = new LengthValidator();

   public LengthValidator getNameLengthValidator()
   {
      return nameLengthValidator;
   } // end method getNameLengthValidator

   public void setNameLengthValidator( LengthValidator lv )
   {
      this.nameLengthValidator = lv;
   } // end method setNameLengthValidator
   // </editor-fold>

   public Validation()
   {
   } // end constructor 

   public void init()
   {
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
         log( "Page1 Initialization Failure" , e );
         throw e instanceof FacesException ? ( FacesException ) e : 
            new FacesException( e );
      }
   // </editor-fold>
   } // end method init

   @Override
   public void preprocess()
   {
   } // end method preprocess

   @Override
   public void prerender()
   {
   } // end method prerender

   @Override
   public void destroy()
   {
   } // end method destroy

   protected SessionBean1 getSessionBean1()
   {
      return ( SessionBean1 ) getBean( "SessionBean1" );
   } // end method getSessionBean1

   protected RequestBean1 getRequestBean1()
   {
      return ( RequestBean1 ) getBean( "RequestBean1" );
   } // end method getRequestBean1

   protected ApplicationBean1 getApplicationBean1()
   {
      return ( ApplicationBean1 ) getBean( "ApplicationBean1" );
   } // end method getApplicationBean1

   // validates entered email address against the regular expression
   // that represents the form of a valid email address
   public void emailTextField_validate( FacesContext context, 
      UIComponent component , Object value )
   {
      String email = String.valueOf( value );

      // if entered email address is not in a valid format
      if ( !email.matches(
         "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*" ) ) {
         throw new ValidatorException( new FacesMessage(
            "Enter a valid email address, e.g. user@domain.com" ) );
      } // end if                                                   
   } // end method emailTextField_validate

   // validates entered phone number against the regular expression
   // that represents the form of a valid phone number
   public void phoneTextField_validate( FacesContext context, 
      UIComponent component , Object value )
   {
      String phone = String.valueOf( value );
      
      // if entered phone number is not in a valid format
      if ( !phone.matches(                                        
         "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}" ) )         
      {                                                           
         throw new ValidatorException( new FacesMessage(          
            "Enter a valid phone number, e.g. (555) 555-1234" ) );
      } // end if                                                 
   } // end method phoneTextField_validate

   // displays the values the user entered and submitted
   public String submitButton_action()
   {
      String name = String.valueOf( nameTextField.getValue() );
      String email = String.valueOf( emailTextField.getValue() );
      String phone = String.valueOf( phoneTextField.getValue() );
      nameValueText.setValue( name );
      emailValueText.setValue( email );
      phoneValueText.setValue( phone );
      gridPanel.setRendered( true );
      resultText.setRendered( true );
      return null;
   } // end method submitButton_action
} // end class Validation


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
