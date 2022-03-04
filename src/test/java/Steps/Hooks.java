package Steps;

import Base.BaseUtilities;
import Utility.Helper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import lombok.var;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Hooks extends BaseUtilities {

    private final BaseUtilities utils;
    private RemoteWebDriver _driver;

    public Hooks(BaseUtilities baseUtilities) {
        utils = baseUtilities;
    }

    @After
    public void TearDown(Scenario scenario) throws IOException {
        var lstData = getCSVData("src/test/resources/ExpectedData.csv");
        List<String> exValue = lstData.get(scenario.getName().toLowerCase().trim());
        if (exValue == null) {
            System.out.println("Please check the Method is implemented or Data is enter into the master list correctly");
        }
        if (exValue.get(1).toLowerCase().equals("yes")) {
            writeCSV(scenario.getName(), scenario.getSourceTagNames().stream().collect(Collectors.toList()).get(0).substring(1), scenario.getStatus().toString(), "NO");
        } else if (exValue.get(1).toLowerCase().equals("no") && scenario.getStatus().toString() == "FAILED") {
            writeCSV(scenario.getName(), scenario.getSourceTagNames().stream().collect(Collectors.toList()).get(0).substring(1), scenario.getStatus().toString(), "NO");
        } else if (exValue.get(1).toLowerCase().equals("no") && scenario.getStatus().toString() == "PASSED") {
            writeCSV(scenario.getName(), scenario.getSourceTagNames().stream().collect(Collectors.toList()).get(0).substring(1), scenario.getStatus().toString(), "YES");
        } else {
            writeCSV(scenario.getName(), scenario.getSourceTagNames().stream().collect(Collectors.toList()).get(0).substring(1), scenario.getStatus().toString(), "UNKNOWN");
        }

        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getName(),
                    new ByteArrayInputStream(((TakesScreenshot) _driver)
                            .getScreenshotAs(OutputType.BYTES)));
        }
        if (_driver != null) {
            _driver.quit();

        }
        System.out.println("Tear down process done");
    }

    @Before
    public void Initialize() throws IOException {
        System.out.println("Initialise process Start");
        String OS = System.getProperty("os.name").toLowerCase();
        SelectBrowser(Browsertype.CHROME);
        utils._driver = _driver;
        File file = new File("TestCases.csv");
        if (!file.exists()) {
            createCSV();
        }
    }

    public void SelectBrowser(Browsertype browser) {

        if (browser == Browsertype.CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
            options.addArguments("enable-automation");
            if (Objects.requireNonNull(Helper.getNodeValue(Helper.filePath, "headless")).equalsIgnoreCase("yes"))
                options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            _driver = new ChromeDriver(options);
            _driver.manage().deleteAllCookies();
            Helper.WaitForPageLoad(_driver, 60);
        } else if (browser == Browsertype.EDGE) {
            System.out.println("Initialise Edge Browser");
        } else if (browser == Browsertype.FIREFOX) {
            System.out.println("Initialise Firefox Browser");
        } else {
            Assert.fail("Please Select a Browser");
        }

    }


    public void createCSV() throws IOException {
        String csvFile = "TestCases.csv";
        CSVWriter cw = new CSVWriter(new FileWriter(csvFile));
        String[] line = {"TestCase", "Category", "Execution Status", "VARIANCE"};
        cw.writeNext(line);
        cw.close();
    }

    public void writeCSV(String category, String testCaseName, String Status, String Variance) throws IOException {
        String csvFile = "TestCases.csv";
        CSVWriter cw = new CSVWriter(new FileWriter(csvFile, true));
        String[] line = {category, testCaseName, Status, Variance};
        cw.writeNext(line);
        cw.close();
    }

    public Map<String, List<String>> getCSVData(String file) {
        Map<String, List<String>> dataLst = new HashMap<>();
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (var item : allData) {
                dataLst.put(item[0].toLowerCase(), Arrays.stream(item).skip(1).collect(Collectors.toList()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return dataLst;
    }
}

enum Browsertype {
    CHROME,
    FIREFOX,
    EDGE
}
