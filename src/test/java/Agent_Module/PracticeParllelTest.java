package Agent_Module;

import org.testng.annotations.Test;
import Convox.GenericLibraries.BaseClass;

public class PracticeParllelTest extends BaseClass {
	
	@Test
	public void Test1()
	{
		System.out.println("- - - Test1 Method Executed - - -"+Thread.currentThread().getId());
	}

	@Test
	public void Test2()
	{
		System.out.println("- - - Test2 Method Executed - - -"+Thread.currentThread().getId());
	}
	
	@Test
	public void Test3()
	{
		System.out.println("- - - Test3 Method Executed - - -"+Thread.currentThread().getId());
	}
}
