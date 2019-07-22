package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsUsage {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
		throw new IllegalStateException("Text ex");
	}

	@Test
	public void test() {
		System.out.println("Test");
		
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("After class");
	}

	@AfterSuite
	public void baftereSuite() {
		System.out.println("After suite");
	}
}