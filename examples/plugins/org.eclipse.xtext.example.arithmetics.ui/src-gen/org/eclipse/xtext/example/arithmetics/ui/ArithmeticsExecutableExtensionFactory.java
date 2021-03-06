/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.arithmetics.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ArithmeticsExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ArithmeticsActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ArithmeticsActivator.getInstance().getInjector(ArithmeticsActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_ARITHMETICS_ARITHMETICS);
	}
	
}
