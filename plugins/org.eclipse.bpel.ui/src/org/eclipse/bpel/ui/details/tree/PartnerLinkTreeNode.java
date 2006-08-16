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

import java.util.ArrayList;
import java.util.List;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.wst.wsdl.PortType;

/**
 * Tree node to represent a PartnerLink model object.
 */
public class PartnerLinkTreeNode extends TreeNode {

	public PartnerLinkTreeNode(PartnerLink partnerLink, boolean isCondensed) {
		super(partnerLink, isCondensed);
	}

	/* ITreeNode */

	public Object[] getChildren() {
		
		PartnerLink partnerLink = (PartnerLink)modelObject;
		
		if (partnerLink == null) {
			return EMPTY_ARRAY;
		}
		
		List list = new ArrayList(2);
		
		Role role = partnerLink.getMyRole();
		PortTypeTreeNode node ;
		if (role != null && !role.eIsProxy() ) {
			node = new PortTypeTreeNode((PortType)role.getPortType(), isCondensed);
			node.setDerivedFromMyRole(true);
			list.add(node);
		}
		
		role = partnerLink.getPartnerRole();
		if (role != null && !role.eIsProxy() )  {
			node = new PortTypeTreeNode((PortType)role.getPortType(), isCondensed);
			node.setDerivedFromPartnerRole(true);
			list.add(node);
		}
		
		return list.toArray();
	}

	public boolean hasChildren() {
		PartnerLink partnerLink = (PartnerLink)modelObject;
		
		if (partnerLink == null)  {
			return false;
		}
		
		Role role = partnerLink.getMyRole();
		if (role != null && !role.eIsProxy()) {
			return true;
		}
		role = partnerLink.getPartnerRole();
		if (role != null && !role.eIsProxy() ) {
			return true;
		}
		return false;
	}
}
