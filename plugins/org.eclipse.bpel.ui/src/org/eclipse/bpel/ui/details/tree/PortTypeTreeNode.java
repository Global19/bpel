/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.tree;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;

/**
 * Tree node to represent a PortType model object.
 */
public class PortTypeTreeNode extends TreeNode {

	// we need these to allow filters to work correctly. 
	
	boolean fDerivedFromMyRole = false;
	boolean fDerivedFromPartnerRole = false;
	
	public PortTypeTreeNode(PortType portType, boolean isCondensed) {
		super(portType, isCondensed);
	}
	
	/* ITreeNode */

	public boolean isDerivedFromMyRole() {
		return fDerivedFromMyRole;
	}

	public void setDerivedFromMyRole(boolean derivedFromMyRole) {
		fDerivedFromMyRole = derivedFromMyRole;
	}

	public boolean isDerivedFromPartnerRole() {
		return fDerivedFromPartnerRole;
	}

	public void setDerivedFromPartnerRole(boolean derivedFromPartnerRole) {
		fDerivedFromPartnerRole = derivedFromPartnerRole;
	}

	public Object[] getChildren() {
		PortType pt = (PortType)modelObject;
		if (pt.getOperations() == null)  return EMPTY_ARRAY;
		Vector v = new Vector();
		for (Iterator it = pt.getOperations().iterator(); it.hasNext(); ) {
			v.add(new OperationTreeNode((Operation)it.next(), isCondensed));
		}
		return v.toArray();
	}

	public boolean hasChildren() {
		PortType pt = (PortType)modelObject;
		if (pt.getOperations() == null)  return false;
		return pt.getOperations().size() > 0;
	}
}
