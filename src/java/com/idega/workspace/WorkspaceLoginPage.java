/*
 * Created on 13.7.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.idega.workspace;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import com.idega.block.login.presentation.Login;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWMainApplication;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.IWContext;
import com.idega.presentation.Page;
import com.idega.presentation.Table;
import com.idega.presentation.app.IWControlCenter;
import com.idega.webface.WFBezel;
import com.idega.webface.WFContainer;
import com.idega.webface.WFUtil;


public class WorkspaceLoginPage extends Page {
	private final static String IW_BUNDLE_IDENTIFIER = "com.idega.webface";
	private IWBundle iwb;
	private IWResourceBundle iwrb;
	String backgroundColor = "#B0B29D";

	public WorkspaceLoginPage() {
		setTransient(false);
	}
	public String getBundleIdentifier() {
		return IW_BUNDLE_IDENTIFIER;
	}
	public void main(IWContext iwc) {
		iwb = this.getBundle(iwc);
		iwrb = this.getResourceBundle(iwc);
		IWMainApplication iwma = iwc.getIWMainApplication();
		Page thePage = this;
		//thePage.setTitle("idegaWeb Applications");
		String productName = iwma.getProductInfo().getFullProductName();
		thePage.setTitle(productName);
		thePage.setStyleClass("ws_loginpage");
		
		Table frameTable = new Table(1, 1);	
		frameTable.setWidth("100%");
		frameTable.setHeight("100%");
		frameTable.setCellpadding(0);
		frameTable.setCellspacing(0);
		frameTable.setAlignment(1, 1, "center");
		frameTable.setVerticalAlignment(1, 1, "middle");
		
		WFBezel mainTable = new WFBezel();
		//mainTable.setWidth("500px");
		//mainTable.setHeight("500px");
		mainTable.setStyleClass("ws_mainloginbox");
		
		//mainTable.setStyleAttribute("background:idegalogin.svg;");
		//mainTable.setStyleAttribute("background","idegalogin.svg");
		
		frameTable.add(mainTable, 1, 1);

		Table dropdownTable = new Table(1, 1);
		dropdownTable.setWidth(148);
		dropdownTable.setCellpadding(0);
		dropdownTable.setCellspacing(0);
		dropdownTable.setAlignment(1, 1, "center");
		//mainTable.setAlignment(1, 3, Table.HORIZONTAL_ALIGN_RIGHT);
		mainTable.add(dropdownTable);

		/*Form myForm = new Form();
		myForm.setEventListener(com.idega.core.localisation.business.LocaleSwitcher.class.getName());
		DropdownMenu dropdown = LocalePresentationUtil.getAvailableLocalesDropdown(iwc);
		dropdown.setStyleAttribute("font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8pt; border-style:solid; border-width:1; border-color: #000000");
		myForm.add(dropdown);
		dropdownTable.add(myForm);*/


		boolean isLoggedOn = false;
		try {
			isLoggedOn = iwc.isLoggedOn();
		}
		catch (Exception e) {
			isLoggedOn = false;
		}

		if (isLoggedOn) {
			IWControlCenter iwcc = new IWControlCenter();
			mainTable.add(iwcc);
			//headerImage = iwrb.getImage("login/header_app_suite.jpg", "", 323, 196);

		}	
			try {
				//WFLogin login = new WFLogin();
				Login login = new Login();
				login.setUseRegularButton();
				login.setNoStyles();
				login.setHeight("60");
				login.setWidth("70");
				
				//login.setAllowCookieLogin(true);
				String workspaceUrl = iwma.getWorkspaceURI();
				login.setUrlToForwardToOnLogin(workspaceUrl);
				
				mainTable.add(login);
			}
			catch (Exception e) {
				add(iwrb.getLocalizedString("login.init.error", "There was an error initialising the login component, most likely it is missing"));
				e.printStackTrace();
			}

		mainTable.add(getProductName());
		mainTable.add(getVersionInfo());
		
		mainTable.add(getBuildId());
		mainTable.add(getCopyrightText());
		
		thePage.add(frameTable);
		//thePage.add(mainTable);
	}

	
	protected UIComponent getVersionInfo(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("versioninfo");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.version");
		cText.add(tText);
		return cText;
	}
	
	protected UIComponent getProductName(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("productinfo");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.fullProductName");
		cText.add(tText);
		return cText;
	}
	
	protected UIComponent getBuildId(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("buildid");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.buildId");
		cText.add(tText);
		return cText;
	}

	protected UIComponent getCopyrightText(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("copyrighttext");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.copyrightText");
		cText.add(tText);
		return cText;
	}		
	
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#encodeBegin(javax.faces.context.FacesContext)
	 */
	public void encodeBegin(FacesContext context) throws IOException {
		super.encodeBegin(context);
	}
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#encodeChildren(javax.faces.context.FacesContext)
	 */
	public void encodeChildren(FacesContext context) throws IOException{
		super.encodeChildren(context);
	}
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#encodeEnd(javax.faces.context.FacesContext)
	 */
	public void encodeEnd(FacesContext context) throws IOException {
		super.encodeEnd(context);
	}
}