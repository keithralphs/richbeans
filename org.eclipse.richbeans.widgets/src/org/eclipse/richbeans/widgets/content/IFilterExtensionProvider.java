/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package org.eclipse.richbeans.widgets.content;

/**
 *
 */
public interface IFilterExtensionProvider {

	/**
	 * The folder syntax is a regular expression but the
	 * . character is automatically escaped.
	 * @return filter strings e.g. {*.xml, *.txt}
	 */
	public String [] getFilterExtensions();
}
