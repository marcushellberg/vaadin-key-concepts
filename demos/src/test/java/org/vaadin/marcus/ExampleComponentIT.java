package org.vaadin.marcus;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.testbench.TestBenchTestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleComponentIT extends TestBenchTestCase {

  @Before
  public void setup() throws Exception {
    setDriver(new ChromeDriver());
    getDriver().get("http://localhost:8080/example");
  }

  @Test
  public void clickButton() {
    ButtonElement button = $(ButtonElement.class).first();
    button.click();
    Assert.assertEquals("Saved", button.getText());
  }

  @After
  public void tearDown() throws Exception {
    getDriver().quit();
  }
}
