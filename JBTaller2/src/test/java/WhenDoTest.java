import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WhenDoTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion","8");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit wait  (tiempo para todos los controles)
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void verifyContactIsCreated() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        String titulo="Titulo de Prueba ";
        String notas="Notas de Prueba ";
        String recordar ="15 minutos antes";

        List<WebElement> myControls;

        // click OK
        /*List<WebElement> myControls= driver.findElements(By.id("android:id/button1"));
        if (myControls.size()>0)
            driver.findElement(By.id("android:id/button1")).click();*/
        int nroNota = 1;
            // click Agregar Alarma
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
            // click Fecha Limite, recordatorio Repetir
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/note_item_reminder")).click();
            // Seleccionar Opción Fijar Fecha Limite
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/due_date")).click();
            // seleccionar una fecha
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"21 diciembre 2020\"]")).click();
            // click en aceptar
            driver.findElement(By.id("android:id/button1")).click();
            // Seleccionar Opción Fijar Hora
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/time")).click();
            // Escoger Hora con click
            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"9\"]")).click();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            // Escoger minutos con click
            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"25\"]")).click();
            // click en aceptar Hora
            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
            // click en Opcion recordar a Tiempo
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/reminder")).click();
            //seleccionar check recordar
            driver.findElement(By.xpath("//android.widget.RadioButton[@text='" + recordar + "']")).click();
            //seleccionar repetir/fijar frecuencia
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/repeat")).click();
            //seleccionar check repetir
            driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Diariamente\"]")).click();
            //Ingresar Titulo
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo+nroNota);
            //Ingresar Notas
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(notas+nroNota);
            //Guardar
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Guardar\"]")).click();

        //WebDriverWait explicitWait = new WebDriverWait(driver,3000);

        myControls= driver.findElements(By.xpath("//android.widget.TextView[@text='"+titulo+nroNota+"']"));
        Assert.assertTrue("ERROR !! El contacto no fue creado",myControls.size()>0);


        do {
            nroNota=nroNota+1;
            // click Agregar Alarma
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
            // click Fecha Limite, recordatorio Repetir
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/note_item_reminder")).click();
            // Seleccionar Opción Fijar Fecha Limite
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/due_date")).click();
            // seleccionar una fecha
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"21 diciembre 2020\"]")).click();
            // click en aceptar
            driver.findElement(By.id("android:id/button1")).click();
            // Seleccionar Opción Fijar Hora
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/time")).click();
            // Escoger Hora con click
            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"9\"]")).click();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            // Escoger minutos con click
            driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"25\"]")).click();
            // click en aceptar Hora
            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
            // click en Opcion recordar a Tiempo
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/reminder")).click();
            //seleccionar check recordar
            driver.findElement(By.xpath("//android.widget.RadioButton[@text='" + recordar + "']")).click();
            //seleccionar repetir/fijar frecuencia
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/repeat")).click();
            //seleccionar check repetir
            driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Diariamente\"]")).click();
            //Ingresar Titulo
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo+nroNota);
            //Ingresar Notas
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(notas+nroNota);
            //Guardar
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Guardar\"]")).click();
        }while(nroNota<13);

        // simulacion SWIPE

        TouchAction action = new TouchAction(driver);
        WebElement start= driver.findElement(By.xpath("//android.view.ViewGroup[8]/android.widget.LinearLayout/android.view.View[1]"));
        WebElement end= driver.findElement(By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.View[1]"));

        int startX= start.getLocation().getX();
        int startY=start.getLocation().getY();

        int endX= end.getLocation().getX();
        int endY=end.getLocation().getY();

        action.press(PointOption.point(new Point(startX,startY)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(new Point(endX,endY)))
                .release().perform();

    }
}
