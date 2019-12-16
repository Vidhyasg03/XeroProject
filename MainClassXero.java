package XeroProject;

import java.io.IOException;

import org.testng.annotations.Test;

public class MainClassXero extends TestBaseXero {
  @Test
  public static void MainClassXero() throws IOException, InterruptedException {
	  InitializeReport();
	  
	  Xero_TCID01_A.Xero_TCID01_A();
	  Xero_TCID01_B.Xero_TCID01_B();
	  Xero_TCID01_C.Xero_TCID01_C();
	  Xero_TCID01_D.Xero_TCID01_D();
	 //Xero_TCID02_A.Xero_TCID02_A();
	  Xero_TCID02_B.Xero_TCID02_B();
	  Xero_TCID02_C.Xero_TCID02_C();
	 Xero_TCID02_D.Xero_TCID02_D();
		reports.flush();
	  
  }
}
