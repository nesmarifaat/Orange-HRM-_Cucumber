package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Utility {
    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate = new Date();
        screenshotName = screenshotName + " " + currntDate.toString().replace(" ", "-").replace(":", "-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/main/resources/Screenshots" + screenshotName + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }



    public static String getSingleJsonData(String jsonFilePath, String jsonField) throws IOException, ParseException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }

    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/main/resources/data_driven/logindata.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }

}
