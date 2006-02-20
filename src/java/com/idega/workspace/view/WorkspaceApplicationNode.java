/**
 * 
 */
package com.idega.workspace.view;

import java.util.ArrayList;
import java.util.Collection;
import com.idega.core.view.ApplicationViewNode;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWMainApplication;


/**
 * <p>
 * TODO tryggvil Describe Type WorkspaceApplicationNode
 * </p>
 *  Last modified: $Date: 2006/02/20 23:24:55 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.1 $
 */
public class WorkspaceApplicationNode extends ApplicationViewNode {

	/**
	 * @param viewId
	 * @param parent
	 */
	public WorkspaceApplicationNode(String viewId, ViewNode parent,Collection roles) {
		super(viewId, parent);
		
		IWMainApplication iwma = getIWMainApplication();
		IWBundle workspaceBundle = iwma.getBundle("com.idega.workspace");
		setJspUri(workspaceBundle.getJSPURI("workspace.jsp"));
		setAuthorizedRoles(roles);
		
	}
}
