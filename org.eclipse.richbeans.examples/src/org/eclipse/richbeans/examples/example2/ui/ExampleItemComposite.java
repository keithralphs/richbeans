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
package org.eclipse.richbeans.examples.example2.ui;

import org.eclipse.richbeans.api.event.ValueListener;
import org.eclipse.richbeans.api.widget.IFieldWidget;
import org.eclipse.richbeans.widgets.BoundsProvider;
import org.eclipse.richbeans.widgets.scalebox.ScaleBox;
import org.eclipse.richbeans.widgets.wrappers.TextWrapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ExampleItemComposite extends Composite {

	private TextWrapper itemName;
	private ScaleBox x,y;

	public ExampleItemComposite(Composite parent, int style) {
		super(parent, style);
		createContent();
	}

	private void createContent() {
		
		setLayout(new GridLayout(2, false));
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Name");
	
		this.itemName = new TextWrapper(this, SWT.BORDER);
		itemName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		label = new Label(this, SWT.NONE);
		label.setText("x");
		
		x = new ScaleBox(this, SWT.NONE);
		x.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		x.setUnit("°");
		x.setMinimum(0);
		x.setMaximum(1000);
		
		label = new Label(this, SWT.NONE);
		label.setText("y");
		
		y = new ScaleBox(this, SWT.NONE);
		y.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		y.setUnit("m");
		y.setMinimum(0);
		y.setMaximum(new BoundsProvider() {
			
			@Override
			public double getBoundValue() {
				return x.getNumericValue()*10;
			}
			
			@Override
			public void addValueListener(ValueListener l) {
				x.addValueListener(l);
			}
		});
	}

	public IFieldWidget getItemName() {
		return itemName;
	}
	
	public IFieldWidget getX() {
		return x;
	}
	
	public IFieldWidget getY() {
		return y;
	}

}
