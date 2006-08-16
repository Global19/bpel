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
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;

/**
 * Tree node to represent a PartnerLinkType model object.
 */

public class PartnerLinkTypeTreeNode extends TreeNode {

	public PartnerLinkTypeTreeNode(PartnerLinkType plt, boolean isCondensed) {
		super(plt, isCondensed);
	}

	/* ITreeNode */

	public Object[] getChildren() {
		
		PartnerLinkType plt = (PartnerLinkType) modelObject;
		if (plt == null) {
			return EMPTY_ARRAY;
		}

		// There is at most, 2 roles
		List v = new ArrayList(2);
		Iterator i = plt.getRole().iterator();
		while (i.hasNext()) {
			Role role = (Role) i.next();
			v.add( new RoleTreeNode ( role ,isCondensed));
		}
		return v.toArray();
	}

	
	public boolean hasChildren() {
		PartnerLinkType plt = (PartnerLinkType) modelObject;
		if (plt == null)  {
			return false;
		}
		return plt.getRole().size() > 0;
	}
}
