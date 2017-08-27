package com.herokuapp.tables;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class EmployeesTableTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("herokuUrl"));
	}

	@Test
	public void test() {
		// print number of rows in table 1
		WebElement webtable1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = webtable1.findElements(By.tagName("tr"));

		System.out.println("webtable1 rows count: " + rows.size());

		// print number of rows in table 2

		WebElement webtable2 = driver.findElement(By.id("table2"));
		List<WebElement> rowst2 = webtable2.findElements(By.tagName("tr"));

		System.out.println("webtable2 rows count: " + rowst2.size());

		List<WebElement> cells = rows.get(0).findElements(By.tagName("th"));
		System.out.println(cells.get(1).getText());

		List<WebElement> cells1 = rows.get(4).findElements(By.tagName("td"));
		System.out.println(cells1.get(4).getText());

	}

	@Test
	public void loopWebTables() {
		WebElement table1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		System.out.println("number of rows in table 1" + rows.size());

		for (WebElement row : rows) {
			// System.out.println(row.getText());
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "|");

			}
			System.out.println();

		}

	}

	@Test
	public void loopTablesXpath() {
		List<WebElement> rowsIntable2 = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		System.out.println("number of rows in table 1" + rowsIntable2.size());

		for (int rowNum = 0; rowNum < rowsIntable2.size(); rowNum++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[" + (rowNum + 1) + "]")).getText());

		}

	}

}
