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
package org.eclipse.bpel.ui.editparts;

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.requests.CreationFactory;


public class CorrelationSetsEditPart extends BPELTrayCategoryEditPart {

	protected CreationFactory getCreationFactory() {
		return UIObjectFactoryProvider.getInstance().getFactoryFor(BPELPackage.eINSTANCE.getCorrelationSet());
	}

	protected List getModelChildren() {
		return getCorrelationSets().getChildren();
	}

	protected CorrelationSets getCorrelationSets() {
		return (CorrelationSets)getModel();
	}

	protected IFigure getAddToolTip() {
	    return new Label(Messages.CorrelationSetsEditPart_Add_Correlation_Set_1); 
	}
	
	protected IFigure getRemoveToolTip() {
	    return new Label(Messages.CorrelationSetsEditPart_Remove_Correlation_Set_1); 
	}	

}
