/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator.rules;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */
public class VariablesValidator extends CContainerValidator {

	/** 
	 * Parent nodes for Variables
	 */
	static public IFilter<INode> PARENTS = Filters.SCOPE_OR_PROCESS;
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#getFilter()
	 */
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {		
		super.checkChildren();
		checkChild(ND_VARIABLE, 1, Integer.MAX_VALUE);
		
	}

	
	/**
	 * Checks if a child element has a duplicate name
	 *
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "12/7/2006",
		desc = "Checks for duplicate variable name",
		sa = 23 ,
		errors="BPELC_DUPLICATE_NAME"
	)
	
	public void rule_CheckDuplicateVariableName_40 () {
		
		checkDuplicateName();
	}
}
