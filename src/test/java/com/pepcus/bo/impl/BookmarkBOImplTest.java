package com.pepcus.bo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pepcus.bo.staticmethods.StaticMethod;

@RunWith(PowerMockRunner.class)//org.powermock.api.mockito.PowerMockito
@PrepareForTest({StaticMethod.class})
public class BookmarkBOImplTest {

	@Before
	public void init() {
		//Call PowerMockito.mockStatic() to mock a static class (use PowerMockito.spy(class) to mock a specific method):
		PowerMockito.mockStatic(StaticMethod.class);
	}
	
	@Test
	////@PrepareForTest({StaticMethod.class})
	public void testFindByAccountUsername() {
		//PowerMockito.mockStatic(StaticMethod.class);
		
		when(StaticMethod.check(any(String.class))).thenReturn("val");
		assertEquals("val", StaticMethod.check(any(String.class)));
	}
	
	@Test
	public void testVeri() throws Exception {
		PowerMockito.spy(StaticMethod.class);
		StaticMethod.check("call");
	}
	
	@Test
	public void testStaticFinal() throws Exception {
		//PowerMockito.spy(StaticMethod.class);
		when(StaticMethod.checkFinal(any(String.class))).thenReturn("val");
		assertEquals("val", StaticMethod.checkFinal(any(String.class)));
	}

}
