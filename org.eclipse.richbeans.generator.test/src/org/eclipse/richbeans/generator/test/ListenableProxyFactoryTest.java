/*-
 * Copyright © 2016 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package org.eclipse.richbeans.generator.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Proxy;

import org.eclipse.richbeans.generator.ListenableProxyFactory;
import org.eclipse.richbeans.generator.ListenableProxyInvocationHandler;
import org.junit.Test;

public class ListenableProxyFactoryTest {
	@Test
	public void testCreatesProxyOfSameType(){
		TestExample proxy = createProxy();
		assertThat(proxy, is(instanceOf(TestExample.class)));
	}

	@Test
	public void testCreatesThatImplementsPropertyChangeListeningAddAndRemove() throws Exception{
		TestExample proxy = createProxy();
		assertThat(proxy.getClass().getMethod("addPropertyChangeListener", PropertyChangeListener.class), notNullValue());
		assertThat(proxy.getClass().getMethod("removePropertyChangeListener", PropertyChangeListener.class), notNullValue());
	}

	@Test
	public void testUsesTheListeningHandler() throws Exception{
		TestExample proxy = createProxy();
		assertThat(Proxy.getInvocationHandler(proxy), is(instanceOf(ListenableProxyInvocationHandler.class)));
	}

	private TestExample createProxy() {
		TestExample proxy = new ListenableProxyFactory<TestExample>(TestExample.class).createProxyFor(mock(TestExample.class));
		return proxy;
	}

	public interface TestExample{
	}
}