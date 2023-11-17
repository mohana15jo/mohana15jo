package org.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	//1--browser launch
	public static void browser_launch() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver(); 
	}
	
	//2--launch website
	public static void passurl(String url) {
		driver.get(url);	
	}
	
	//3--maximize window 
	public static void maxwindow()
	{
		driver.manage().window().maximize();
	}
	
	//4--getTitle
	public static String get_Title()
	{
		String title = driver.getTitle();
		return title;
	}
	
	//5--getCurrenturl
	public static String get_Currenturl() {
		String a=driver.getCurrentUrl();
		return a;
	}
	
	//6--sendkeys
	public static void fill(WebElement ele,String value) {
		
		ele.sendKeys(value);
	}
	
	//7--quit--entire browser
	public static void quit_browser()
	{
		driver.quit();
	}
	
	//8--close--current browser
	public static void close_browser()
	{
		driver.close();
	}
	
	//9--getText
	public static String get_text(WebElement ele)
	{
		String text = ele.getText();
		return text;
	}
	
	//10--getAttribute
	public static void get_Attribute(WebElement ele)
	{
		ele.getAttribute("value");
	}
	
	//11--alert-accept
	public static void alert_accept()
	{
		
		Alert a =driver.switchTo().alert();
		a.accept();
	}
	
	//12--alert-dismiss
	public static void alert_dismiss()
	{
		Alert a =driver.switchTo().alert();
		a.dismiss();
	}

	//13--alert-sendkeys
	public static void alert_sendkeys(String s)
	{
		Alert a =driver.switchTo().alert();
		a.sendKeys(s);
	}
	//14--alert-gettext
	public static void alert_getText()
	{
		Alert a =driver.switchTo().alert();
		a.getText();
	}
	//15--click
	public static void click_option(WebElement ele) {
		ele.click();
	}
	
	//16--clear
	public static void text_clear(WebElement ele) {
		ele.clear();
	}
	
	//17--actions-moveToElement
	public static void actions_moveToElement(WebElement action) {
		Actions act=new Actions(driver);
		act.moveToElement(action).perform();
	}
	
	//18--actions-draganddrop
	public static void actions_dragAndDrop(WebElement ele1,WebElement ele2) {
		Actions act=new Actions(driver);
		act.dragAndDrop(ele1, ele2).perform();
	}
	
	//19--actions--doubleclick
	public static void actions_doubleClick() {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	//20--actions--contextClick
	public static void actions_contextClick() {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	//21--actions--build
	public static void actions_build() {
		Actions act=new Actions(driver);
		act.build().perform();
	}
	//22--actions--keyUP
	public static void actions_KeyUp(String s) {
		Actions act=new Actions(driver);
		act.keyUp(s).perform();
	}
	
	//23--actions --keydown
	public static void actions_Keydown(String s) {
		Actions act=new Actions(driver);
		act.keyDown(s).perform();
	}
	
	//24--Robot--copy
		public static void robot_copy() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
	}
		
	//25--Robot--paste
	public static void robot_paste() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
	}
	//26--Robot--keydown
	public static void robot_keydown() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
	}
	
	//27--robot--shift
	public static void robot_shift() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_SHIFT);
	
	}
	//28--javascript
	public static void javaScript(String script,WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script,ele);
	
	}
	
	//29--Perform Click using JavascriptExecutor		
	public static void javaScript_button(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", ele);
	}
	
	//30--perform scrolldown using javascript
	public static void javaScript_scrolldown(WebElement ele) {
		JavascriptExecutor j=(JavascriptExecutor)driver;	
		j.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	//31--screenshot
	public static void screenshot() throws Exception{
		TakesScreenshot t=(TakesScreenshot)driver;
		File screen=t.getScreenshotAs(OutputType.FILE);
		
		File fil1=new File("C:\\Users\\Mohana\\eclipse-workspace\\Selenium_learning\\ScreenShots\\screen1.jpg");
		 
		FileUtils.copyFile(screen, fil1);
	}
	
	//32--frame_id
	public static void frame_id(int i)
	{
		driver.switchTo().frame(i);
	}
	//33--frame_name
	public static void frame_name(String name)
	{
		driver.switchTo().frame(name);
	}
		
	//34--frame_WebElemnt
	public static void frame_WebElement(WebElement ele)
	{			driver.switchTo().frame(ele);
	}
	
	//35---drop_down_index
	public static void dropdown_index(WebElement ele,int index) {
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	//36---drop_down_value
	public static void dropdown_value(WebElement ele,String v) {
		Select s=new Select(ele);
		s.selectByValue(v);
	}
	
	//37---drop_down_VisibleByText
	public static void dropdown_VisibleByText(WebElement ele,String v) {
		Select s=new Select(ele);
		s.selectByVisibleText(v);
	}
	
	//38--drop_down_ismultiply
	public static void dropdown_isMultiple(WebElement ele)
	{
		Select s=new Select(ele);
		s.isMultiple();
	}
	
	
	//39--drop_down - getoptions
	public static void dropdown_getoptions(WebElement ele)
	{
		Select s=new Select(ele);
		s.getOptions();
	}
	
	//40--drop_down -getfirstselectoptions
	public static void dropdown_getfirstselectoptions(WebElement ele)
	{
		Select s=new Select(ele);
		s.getFirstSelectedOption();
	}
	
	
	//41--drop_down- getallselectedoptions
	public static void dropdown_getallselectedoptions(WebElement ele)
	{
		Select s=new Select(ele);
		s.getAllSelectedOptions();
	}
	
	//42--drop_down- deselctByindex
	public static void dropdown_getallselectedoptions(int i,WebElement ele)
	{
		Select s=new Select(ele);
		s.deselectByIndex(i);
	
	}
	
	//43--drop_down -deselectByValue
	public static void dropdown_getallselectedoptions(WebElement ele,String v)
	{
		Select s=new Select(ele);
		s.deselectByValue(v);
	}
	
	//44--drop-down- deselectByVisibleText
	public static void dropdown_deselectByVisibleText(WebElement ele,String v)
	{
		Select s=new Select(ele);
		s.deselectByVisibleText(v);
	}
	
	//45--dropdown - deselectAll
	public static void dropdown_deselected(WebElement ele)
	{
		Select s=new Select(ele);
		s.deselectAll();
	}
	
	//46--	windowshandling using url/title/id
	public static void windowshandling_url(String s) {
		driver.switchTo().window(s);
	}
	
	
	//47-- Static wait
	public static void static_wait(int i) throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	//48--dynamic wait-implicit
	public static void implicit_wait(int time){
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	//49--dynamic wait-fluent
	public static void fluent_wait(WebElement ele) {
		FluentWait<WebDriver> fw=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(Throwable.class);
				fw.until(ExpectedConditions.presenceOfElementLocated((By) ele));
	}
	
	//50--dynamic wait - webdriver_wait -presenceOfAllElementsLocatedBy
	public static void wait_presenceOfAllElementsLocatedBy(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) ele));
		
	}
	
	//51--dynamic wait - webdriver_wait -alertIsPresent
	public static void wait_alertIsPresent() {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.alertIsPresent());
	}
	
	
	//52--dynamic wait - webdriver_wait -elementSelectionStateToBe
	public static void wait_elementSelectionStateToBe(WebElement ele1,boolean ele2) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementSelectionStateToBe(ele1, ele2));
	}
				
	//53--dynamic wait - webdriver_wait -elementToBeClickable
	public static void wait_elementtobeClick(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	//54--dynamic wait - webdriver_wait -elementtoBeSelect
	public static void wait_elementToBeSelected(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeSelected(ele));
		
	}
	
	//55--dynamic wait - webdriver_wait -frameToBeAvailableAndSwitchToIt
	public static void wait_frameToBeAvailableAndSwitchToIt(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}
	
	//56--dynamic wait - webdriver_wait -invisibilityOfElementLocated
	public static void wait_invisibilityOfElementLocated(By ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	}
				
	//57--dynamic wait - webdriver_wait -invisibilityOfElementLocated
	public static void wait_invisibilityOfElementLocated(By ele,String s) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.invisibilityOfElementWithText(ele, s));
	}
	
				
	//58--dynamic wait - webdriver_wait -invisibilityOfAllElements
	public static void wait_invisibilityOfAllElements(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.invisibilityOfAllElements(ele));
	}
			
	//59--dynamic wait - webdriver_wait -invisibilityOf
	public static void wait_invisibilityOf(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	//60--dynamic wait - webdriver_wait -presenceOfElementLocated
	public static void wait_presenceOfElementLocated(By ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
	
	//61--dynamic wait - webdriver_wait -textToBePresentInElement
	public static void wait_textToBePresentInElement(WebElement ele,String s) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.textToBePresentInElement(ele, s));
	}
	
	//62--dynamic wait - webdriver_wait -textToBePresentInElementValue
	public static void wait_textToBePresentInElementValue(WebElement ele,String s) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.textToBePresentInElementValue(ele, s));
	}
	
	//63--dynamic wait - webdriver_wait -titleContains
	public static void wait_titleContains(String s) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.titleContains(s));
	}
		
	//64--dynamic wait - webdriver_wait_titleIs
	public static void wait_titleIs(String s) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.titleIs(s));
	}
	
	//65--dynamic wait - webdriver_wait_visibilityOf
	public static void wait_VisibilityOf(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 40);
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//66--dynamic wait - webdriver_wait_visibilityOfAllElements
	public static void wait_VisibilityOfAllElement(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
	//67--dynamic wait - webdriver_wait_visibilityOf
	public static void wait_VisibilityOfElementLocated(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//68--Navigation--to(url)
	public static void navigation_to(String s) {
		driver.navigate().to(s);
	}
	
	//69--Navigation --forward
	public static void navigation_forward() {
		driver.navigate().forward();
	}
	
	//70--Navigation -- back
	public static void navigation_back() {
		driver.navigate().back();
	}
	
	//71--Navigation --refreash
	public static void navigation_refreash() {
		driver.navigate().refresh();
	}
	
	//72--IsDisplayed
	public static void Isdisplayed(WebElement ele)
	{
		ele.isDisplayed();
	}
	
	
	//73--IsEnabled
	public static void  IsEnabled(WebElement ele)
	{
		ele.isEnabled();
	}
	
	//74--IsSelected
	public static void  isSelected(WebElement ele)
	{
		ele.isSelected();
	}
	
	//75--getTagname
	public static void  cl(WebElement ele)
	{
		ele.getTagName();
	}
	
	//76--getdata from the excel
	public static String getdata(String filename,String sh,int row,int column) throws IOException {
		String value=null;
		//1.declare the file
		File f=new File(filename);
		
		//2.Read data from the sheet
		FileInputStream fin =new FileInputStream(f);
		
		//3.type of workbook
		Workbook w=new XSSFWorkbook(fin);
		//4.sheet
		Sheet s=w.getSheet(sh);

			Row r = s.getRow(row);
			
			Cell c=r.getCell(column);	
				
			int cell_type = c.getCellType();
			if(cell_type==1) {
				value = c.getStringCellValue();
				System.out.println(value);
				
			}
			else if(DateUtil.isCellDateFormatted(c)) {
				java.util.Date d= c.getDateCellValue();
				SimpleDateFormat sin=new SimpleDateFormat("dd/MM/yyyy");
				 value=sin.format(d);
				 System.out.println(value);
			}
			else {
				double n=c.getNumericCellValue();
				
				long l=(long)n;
				 value=String.valueOf(l);
				 System.out.println(value);
			}
			return value;
			
	}
	public static <Sheet> void putdata(String filename,String sh,int row,int column, String value) throws IOException 
	{/*
		//1.declare the file
		File f=new File(filename);
		
		//2.Read data from the sheet
		FileInputStream fin =new FileInputStream(f);
		
		//3.type of workbook
		WorkbookDocument w=new WorkbookDocument(fin);
		//4.sheet
		Sheet s=((Object) w).getSheet(sh);
		
		Row r=((Object) s).getRow(row);
		
		Cell c=r.createCell(column);
	
		c.setCellValue(value);
		FileOutputStream fout= new FileOutputStream(f);
		((FileOutputStream) w).write(fout);
		*/
		
	}
	
	public static WebElement get_Text(List<WebElelemnet> mobile2)
	{
		WebElement mobile;
		String text;
		List<WebElement> m=new LinkedList<WebElement>();
		m.add(mobile2);
		for(int i=0;i<m.size();i++) {
			mobile=m.get(i);
			System.out.println(mobile.getText());
		//return text;
		}
	
	
	}
}