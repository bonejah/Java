<?xml version="1.0" encoding="UTF-8"?>
<!-- Fig. 30.6: AddressBook.jsp -->
<!-- AddressBook JSP with an add form and a Table JSF component. -->
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
                  <webuijsf:staticText id="instructionText" 
                     style="font-size: 18px; left: 24px; top: 24px; 
                        position: absolute" 
                     text="Add a contact to the address book:"/>
                  <webuijsf:label for="firstNameTextField" 
                     id="firstNameLabel" style="left: 24px; top: 72px; 
                        position: absolute" text="First name:"/>
                  <webuijsf:textField 
                     binding="#{AddressBook.firstNameTextField}" 
                     id="firstNameTextField" maxLength="30" 
                     required="true" style="left: 120px; top: 72px; 
                        position: absolute"/>
                  <webuijsf:label for="lastNameTextField" 
                     id="lastNameLabel" style="left: 25px; top: 96px; 
                        position: absolute" text="Last name:"/>
                  <webuijsf:textField 
                     binding="#{AddressBook.lastNameTextField}" 
                     id="lastNameTextField" maxLength="30" required="true"
                     style="left: 120px; top: 96px; position: absolute"/>
                  <webuijsf:label for="streetTextField" id="streetLabel" 
                     style="left: 49px; top: 120px; position: absolute" 
                     text="Street:"/>
                  <webuijsf:textField 
                     binding="#{AddressBook.streetTextField}" 
                     id="streetTextField" maxLength="150" required="true" 
                     style="left: 120px; top: 120px; position: absolute"/>
                  <webuijsf:label for="cityTextField" id="cityLabel" 
                     style="left: 62px; top: 144px; position: absolute" 
                     text="City:"/>
                  <webuijsf:textField 
                     binding="#{AddressBook.cityTextField}" 
                     id="cityTextField" maxLength="30" required="true" 
                     style="left: 120px; top: 144px; position: absolute"/>
                  <webuijsf:label for="stateTextField" id="stateLabel" 
                     style="left: 55px; top: 168px; position: absolute" 
                     text="State:"/>
                  <webuijsf:textField 
                     binding="#{AddressBook.stateTextField}" 
                     id="stateTextField" maxLength="2" required="true" 
                     style="left: 120px; top: 168px; position: absolute"/>
                  <webuijsf:label for="zipTextField" id="zipLabel" 
                     style="left: 66px; top: 192px; position: absolute" 
                     text="Zip:"/>
                  <webuijsf:textField 
                     binding="#{AddressBook.zipTextField}" 
                     id="zipTextField" maxLength="5" required="true" 
                     style="left: 120px; top: 192px; position: absolute"/>
                  <webuijsf:button 
                     actionExpression="#{AddressBook.submitButton_action}"
                     id="submitButton" primary="true" style="left: 47px; 
                        top: 240px; position: absolute; width: 95px" 
                     text="Submit"/>
                  <webuijsf:button id="clearButton" reset="true" 
                     style="left: 150px; top: 240px; position: absolute; 
                        width: 96px" text="Clear"/>
                  <webuijsf:table augmentTitle="false" 
                     binding="#{AddressBook.addressesTable}" 
                     id="addressesTable" paginateButton="true"
                     paginationControls="true" style="left: 24px; 
                        top: 288px; position: absolute" 
                     title="Contacts" width="744">
                     <webuijsf:tableRowGroup id="tableRowGroup1" rows="5" 
                        sourceData="#{AddressBook.addressesDataProvider}"
                        sourceVar="currentRow">
                        <webuijsf:tableColumn headerText="First name" 
                           id="firstNameColumn" 
                           sort="ADDRESSES.FIRSTNAME">
                           <webuijsf:staticText id="staticText1" 
                              text="#{currentRow.value[
                                 'ADDRESSES.FIRSTNAME']}"/>
                        </webuijsf:tableColumn>
                        <webuijsf:tableColumn headerText="Last name" 
                           id="lastNameColumn" sort="ADDRESSES.LASTNAME">
                           <webuijsf:staticText id="staticText2" 
                              text="#{currentRow.value[
                                 'ADDRESSES.LASTNAME']}"/>
                        </webuijsf:tableColumn>
                        <webuijsf:tableColumn headerText="Street" 
                           id="streetColumn" sort="ADDRESSES.STREET">
                           <webuijsf:staticText id="staticText3" 
                              text="#{currentRow.value[
                                 'ADDRESSES.STREET']}"/>
                        </webuijsf:tableColumn>
                        <webuijsf:tableColumn headerText="City" 
                           id="cityColumn" sort="ADDRESSES.CITY">
                           <webuijsf:staticText id="staticText4" 
                              text="#{currentRow.value[
                                 'ADDRESSES.CITY']}"/>
                        </webuijsf:tableColumn>
                        <webuijsf:tableColumn headerText="State" 
                           id="stateColumn" sort="ADDRESSES.STATE">
                           <webuijsf:staticText id="staticText5" 
                              text="#{currentRow.value[
                                 'ADDRESSES.STATE']}"/>
                        </webuijsf:tableColumn>
                        <webuijsf:tableColumn headerText="zip" 
                           id="zipColumn" sort="ADDRESSES.ZIP">
                           <webuijsf:staticText id="staticText6" 
                              text="#{currentRow.value[
                                 'ADDRESSES.ZIP']}"/>
                        </webuijsf:tableColumn>
                     </webuijsf:tableRowGroup>
                  </webuijsf:table>
                  <webuijsf:messageGroup id="messageGroup1" 
                     showGlobalOnly="true" 
                     style="left: 264px; top: 72px; position: absolute"/>
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


