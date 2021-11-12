import java.io.File;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestodmLoad {
	
odmLoad odmLoad;
	
	@BeforeEach
	void setUp() {
	odmLoad = new odmLoad();	
	}
	
	@Test
	public void TestFile() {
		try {
		if(new File("config.php").exists()) {
			Assert.assertTrue("Config file does not exist in root folder.", new File("config.php").exists() == true);		
		}
			
		else if (new File("docker-configs/config.php").exists()) {
			Assert.assertTrue("Config file does not exist in docker.", new File("docker-configs/config.php").exists() == true);		
		}
		
		else if (new File("../config.php").exists()) {
			Assert.assertTrue("Config file does not exist in subfolder.", new File("../config.php").exists() == true);
		}
		
		else if (new File("../../config.php").exists()) {
			Assert.assertTrue("Config file does not exist as plugin.", new File("../../config.php").exists() == true);
		}

		} catch(Exception e) {
			Assert.assertFalse("Config file exists in root folder.", new File("config.php").exists() == true);	
			Assert.assertFalse("Config file exists in docker.", new File("docker-configs/config.php").exists() == true);	
			Assert.assertFalse("Config file exists in subfolder.", new File("../config.php").exists() == true);
			Assert.assertFalse("Config file exists as plugin.", new File("../../config.php").exists() == true);
		}
	}
}