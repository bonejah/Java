<?xml version="1.0" encoding="UTF-8"?>

<!-- Fig. 29.19: Options.jsp -->
<!-- JSP file that allows the user to select a programming language -->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" 
   xmlns:h="http://java.sun.com/jsf/html" 
   xmlns:jsp="http://java.sun.com/JSP/Page" 
   xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
   <jsp:directive.page contentType="text/html;charset=UTF-8" 
      pageEncoding="UTF-8"/>
   <f:view>
      <webuijsf:page id="page1">
         <webuijsf:html id="html1">
            <webuijsf:head id="head1">
               <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
            </webuijsf:head>
            <webuijsf:body id="body1" style="-rave-layout: grid">
               <webuijsf:form id="form1">
                  <webuijsf:staticText 
                     binding="#{Options.instructionText}" 
                     id="instructionText" style="font-size: 18px; 
                        left: 24px; top: 24px; position: absolute" 
                     text="Select a programming language:"/>
                  <webuijsf:radioButtonGroup 
                     binding="#{Options.languageRadioButtonGroup}" 
                     id="languageRadioButtonGroup" items="#{Options.
                        languageRadioButtonGroupDefaultOptions.options}"
                     style="left: 24px; top: 48px; position: absolute"/>
                  <webuijsf:button 
                     actionExpression="#{Options.submitButton_action}" 
                     binding="#{Options.submitButton}" id="submitButton"
                     style="left: 23px; top: 168px; position: absolute" 
                     text="Submit"/>
                  <webuijsf:staticText binding="#{Options.responseText}" 
                     id="responseText" rendered="false" 
                     style="font-size: 18px; left: 24px; top: 24px; 
                        position: absolute"/>
                  <webuijsf:hyperlink 
                     actionExpression="#{Options.languagesLink_action}" 
                     binding="#{Options.languagesLink}" id="languagesLink"
                     rendered="false" style="left: 24px; top: 72px; 
                        position: absolute" 
                     text="Click here to choose another language."/>
                  <webuijsf:hyperlink 
                     binding="#{Options.recommendationsLink}"
                     id="recommendationsLink" rendered="false" 
                     style="left: 24px; top: 96px; position: absolute"
                     text="Click here to get book recommendations." 
                     url="/faces/Recommendations.jsp"/>
               </webuijsf:form>
            </webuijsf:body>
         </webuijsf:html>
      </webuijsf:page>
   </f:view>
</jsp:root>

<!-- 
********************************************************************** 
* (C) Copyright 1992-2010 by Deitel & Associates, Inc. and           *
* Pearson Education, Inc. All Rights Reserved.                       *
*                                                                    *
* DISCLAIMER: The authors and publisher of this book have used their *
* best efforts in preparing the book. These efforts include the      *
* development, research, and testing of the theories and programs    *
* to determine their effectiveness. The authors and publisher make   *
* no warranty of any kind, expressed or implied, with regard to      *
* these programs or to the documentation contained in these books.   *
* The authors and publisher shall not be liable in any event for     *
* incidental or consequential damages in connection with, or         *
* arising out of, the furnishing, performance, or use of these       *
* programs.                                                          *
********************************************************************** 
-->

