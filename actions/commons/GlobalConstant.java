package commons;

public class GlobalConstant {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");

    // App Infor User
    public static final String DEV_USER_URL = "";
    public static final String TEST_USER_URL = "";
    public static final String STAGING_USER_URL = "";
    public static final String PROD_USER_URL = "";

    // App Infor Admin
    public static final String DEV_ADMIN_URL = "";
    public static final String TEST_ADMIN_URL = "";
    public static final String STAGING_ADMIN_URL = "";
    public static final String PROD_ADMIN_URL = "";

    // Wait Infor
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

    // Download / Upload file
    public static final String DOWNLOAD_FOLDER = PROJECT_PATH + "\\downloadFiles";
    public static final String UPLOAD_FOLDER = PROJECT_PATH + "\\uploadFiles";

    // Retry case failed
    public static final int RETRY_COUNT = 3;

    // Browser log/ extension
    public static final String FIREFOX_EXTENSION_FOLDER = PROJECT_PATH + "\\browserExtension\\Firefox";
    public static final String CHROME_EXTENSION_FOLDER = PROJECT_PATH + "\\browserExtension\\Chrome";
    public static final String EDGE_EXTENSION_FOLDER = PROJECT_PATH + "\\browserExtension\\Edge";
    public static final String FIREFOX_EXTENSION_NAME = PROJECT_PATH + "\\browserExtension\\Firefox\\extension_1_0_0_0.xpi";


    // HTML Report Folder
    public static final String HTML_REPORT_FOLDER = PROJECT_PATH + "\\target\\html-report";

    // Data test
    public static final String DATA_TEST_PATH = PROJECT_PATH + "\\dataTest\\dataTest.xlsx";




}
