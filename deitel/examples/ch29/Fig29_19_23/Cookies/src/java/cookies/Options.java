// Fig. 29.21: Options.java
// Page bean that stores user's language selection 
// as a cookie on the client.
package cookies;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Options extends AbstractPageBean
{
   // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
   private void _init() throws Exception
   {
      languageRadioButtonGroupDefaultOptions.setOptions( 
         new com.sun.webui.jsf.model.Option[]
         {
            new com.sun.webui.jsf.model.Option( "Java", "Java" ), 
            new com.sun.webui.jsf.model.Option( "C++", "C++" ), 
            new com.sun.webui.jsf.model.Option( "Visual-Basic-2008", 
               "Visual Basic 2008" ), 
            new com.sun.webui.jsf.model.Option( "Visual-C#-2008", 
               "Visual C# 2008" ), 
            new com.sun.webui.jsf.model.Option( "Internet-&-Web", 
               "Internet & Web" )
         } // end array initializer
      ); // end call to setOptions
   } // end method _init

   private SingleSelectOptionsList languageRadioButtonGroupDefaultOptions =
      new SingleSelectOptionsList();

   public SingleSelectOptionsList getLanguageRadioButtonGroupDefaultOptions()
   {
      return languageRadioButtonGroupDefaultOptions;
   }

   public void setLanguageRadioButtonGroupDefaultOptions( SingleSelectOptionsList ssol )
   {
      this.languageRadioButtonGroupDefaultOptions = ssol;
   }
   
   private RadioButtonGroup languageRadioButtonGroup = new RadioButtonGroup();

   public RadioButtonGroup getLanguageRadioButtonGroup()
   {
      return languageRadioButtonGroup;
   }

   public void setLanguageRadioButtonGroup( RadioButtonGroup rbg )
   {
      this.languageRadioButtonGroup = rbg;
   }
   
   private StaticText responseText = new StaticText();

   public StaticText getResponseText()
   {
      return responseText;
   }

   public void setResponseText( StaticText st )
   {
      this.responseText = st;
   }
   
   private Hyperlink languagesLink = new Hyperlink();

   public Hyperlink getLanguagesLink()
   {
      return languagesLink;
   }

   public void setLanguagesLink( Hyperlink h )
   {
      this.languagesLink = h;
   }
   
   private Hyperlink recommendationsLink = new Hyperlink();

   public Hyperlink getRecommendationsLink()
   {
      return recommendationsLink;
   }

   public void setRecommendationsLink( Hyperlink h )
   {
      this.recommendationsLink = h;
   }

   private StaticText instructionText = new StaticText();

   public StaticText getInstructionText()
   {
      return instructionText;
   }

   public void setInstructionText( StaticText st )
   {
      this.instructionText = st;
   }
   private Button submitButton = new Button();

   public Button getSubmitButton()
   {
      return submitButton;
   }

   public void setSubmitButton( Button b )
   {
      this.submitButton = b;
   }
   // </editor-fold>

   private HashMap<String, String> books = new HashMap<String, String>();

   // Construct a new page bean instance and initialize the properties
   // that map languages to ISBN numbers of recommended books.
   public Options()
   {
      // initialize HashMap object of values to be stored as cookies.
      books.put( "Java", "0132222205" );
      books.put( "C++", "0136152503" );
      books.put( "Visual-Basic-2008", "013605305X" );
      books.put( "Visual-C#-2008", "013605322X" );
      books.put( "Internet-&-Web", "0131752421" );
   } // end Options constructor

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
   }

   @Override
   public void destroy()
   {
   }

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

   // Action handler for the Submit button. Checks whether a language
   // was selected and, if so, creates a cookie for that language and
   // sets the responseText to indicate the chosen language.
   public String submitButton_action()
   {
      String message = "Welcome to Cookies! You ";

      // if the user made a selection
      if ( languageRadioButtonGroup.getSelected() != null )
      {
         String language =
            languageRadioButtonGroup.getSelected().toString();
         message += "selected " + language.replace( '-', ' ' ) + ".";

         // get ISBN number of book for the given language
         String ISBN = books.get( language );

         // create cookie using language-ISBN name-value pair
         Cookie cookie = new Cookie( language, ISBN );

         // add cookie to response header to place it on user's machine
         HttpServletResponse response =
            ( HttpServletResponse ) getExternalContext().getResponse();
         response.addCookie( cookie );
      } // end if
      else
      {
         message += "did not select a language.";
      } // end else

      responseText.setValue( message );
      languageRadioButtonGroup.setRendered( false ); // hide
      instructionText.setRendered( false ); // hide
      submitButton.setRendered( false ); // hide
      responseText.setRendered( true ); // show
      languagesLink.setRendered( true ); // show
      recommendationsLink.setRendered( true ); // show
      return null; // reloads the page
   } // end method submitButton_action

   // redisplay the components for selecting a language
   public String languagesLink_action()
   {
      responseText.setRendered( false ); // hide
      languagesLink.setRendered( false ); // hide
      recommendationsLink.setRendered( false ); // hide
      languageRadioButtonGroup.setRendered( true ); // show
      instructionText.setRendered( true ); // show
      submitButton.setRendered( true ); // show
      return null; // reloads the page
   } // end method languagesLink_action
} // end class Options

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

