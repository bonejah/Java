<?xml version="1.0" encoding="UTF-8"?>
<!-- Fig. 23.17 Reserve.jsp -->
<!-- JSP that allows a user to select a seat -->
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
                  <webuijsf:label binding="#{Reserve.instructionLabel}"
                     id="instructionLabel"
                     style="left: 24px; top: 24px; position: absolute"
                     text="Please select the seat type and class to
                        reserve:"/>
                  <webuijsf:dropDown binding="#{Reserve.seatTypeDropDown}"
                     id="seatTypeDropDown" items="#{Reserve.
                        seatTypeDropDownDefaultOptions.options}"
                     style="left: 24px; top: 48px; position: absolute"
                     valueChangeListenerExpression=
                        "#{Reserve.seatTypeDropDown_processValueChange}"/>
                  <webuijsf:dropDown
                     binding="#{Reserve.classTypeDropDown}"
                     id="classTypeDropDown" items="#{Reserve.
                        classTypeDropDownDefaultOptions.options}"
                     style="left: 96px; top: 48px; position: absolute"
                     valueChangeListenerExpression="#{Reserve.
                        classTypeDropDown_processValueChange}"/>
                  <webuijsf:button
                     actionExpression="#{Reserve.reserveButton_action}"
                     binding="#{Reserve.reserveButton}" id="reserveButton"
                     style="left: 191px; top: 48px; position: absolute"
                     text="Reserve"/>
                  <webuijsf:label binding="#{Reserve.successLabel}"
                     id="successLabel" rendered="false" style="left: 24px;
                        top: 24px; position: absolute"
                     text="Your reservation has been made. Thank you!"/>
                  <webuijsf:label binding="#{Reserve.errorLabel}"
                     id="errorLabel" rendered="false" style="color: red;
                        left: 24px; top: 96px; position: absolute"
                     text="This type of seat is not available. Please
                        modify your request and try again."/>
               </webuijsf:form>
            </webuijsf:body>
         </webuijsf:html>
      </webuijsf:page>
   </f:view>
</jsp:root>

<!--
**********************************************************************
* (C) Copyright 1992-2009 by Deitel & Associates, Inc. and           *
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

