package com.casmall.dts.manage.ui.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.casmall.dts.manage.ui.auth.AuthMgtEditComposite;
import com.casmall.dts.manage.ui.auth.AuthMgtListComposite;
import com.casmall.dts.ui.common.ListAndEditSashComposite;

public class AuthMgtView extends ViewPart {
	public static final String ID = AuthMgtView.class.getName();
	public AuthMgtView() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		ListAndEditSashComposite comp = new ListAndEditSashComposite(parent, SWT.NULL);
		comp.setComposite(new AuthMgtListComposite(comp.getSashForm(), SWT.PUSH | SWT.CENTER), new AuthMgtEditComposite(comp.getSashForm(), SWT.PUSH | SWT.CENTER));
		comp.setWeights(new int[] { 70, 30});
	}

	@Override
	public void setFocus() {
	}
}
