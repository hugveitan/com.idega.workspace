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
		String productName = iwma.getProductInfo().getFullProductName();
		thePage.setTitle(productName);
		thePage.setStyleClass("ws_loginpage");

		WFBezel loginBox = new WFBezel();
		loginBox.setStyleClass("ws_mainloginbox");
		
		//This is a hack to make form elements respond in IE with a transparent IE
		WFContainer ieHack = new WFContainer();
		ieHack.setStyleClass("iehack");
		ieHack.setStyleAttribute("position","relative");
		ieHack.setStyleAttribute("margin","0");
		ieHack.setStyleAttribute("padding","0");
		loginBox.add(ieHack);
		add(loginBox);
		

		boolean isLoggedOn = false;
		try {
			isLoggedOn = iwc.isLoggedOn();
		}
		catch (Exception e) {
			isLoggedOn = false;
		}

		if (isLoggedOn) {
			//commented out this is now a security hole:
			//IWControlCenter iwcc = new IWControlCenter();
			//loginBox.add(iwcc);
		}	
			//WFLogin login = new WFLogin();
			Login login = new Login();
			login.setUseRegularButton();
			login.setNoStyles();
			login.setHeight("60");
			login.setWidth("70");
			
			//login.setAllowCookieLogin(true);
			String workspaceUrl = iwma.getWorkspaceURI();
			login.setUrlToForwardToOnLogin(workspaceUrl);
			
			loginBox.add(login);


		loginBox.add(getProductName());
		loginBox.add(getVersionInfo());
		loginBox.add(getBuildId());
		loginBox.add(getCopyrightText());
		
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