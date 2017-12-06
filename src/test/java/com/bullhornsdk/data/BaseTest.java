package com.bullhornsdk.data;

import org.junit.Before;

import com.bullhornsdk.data.api.BullhornData;


public class BaseTest {

	
	public TestEntities testEntities;

	public BullhornData bullhornData;

	@Before
	public void scaffoldTests() {
		this.testEntities = new TestEntities();
	}

}
