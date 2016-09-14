package demo.upload.util;

import demo.upload.http.HttpReturnValue;
import demo.upload.http.HttpUtils;
import org.joda.time.DateTime;

import java.io.File;

public class ImagePushUtil {
    private static final String DEFAULT_LOGO_FULL_PATH_FILE_NAME = "/logo/default.jpg";
    private static final String STATIC_SERVER_UPLOAD_URL = "http://202.199.162.212:8000/upload";

    public static HttpReturnValue push(File sourceFile) {
        HttpReturnValue hrv = new HttpReturnValue();

        if (HttpUtils.post(sourceFile, STATIC_SERVER_UPLOAD_URL)) {
            hrv.setSuccess(true);
            hrv.setDestFileName(sourceFile.getName());
            hrv.setDirPath("/" + new DateTime().toString("YYMMdd") + "/");
            hrv.setSourceFileName(sourceFile.getName());
        } else {
            hrv.setSuccess(false);
            hrv.setFullPathFile(DEFAULT_LOGO_FULL_PATH_FILE_NAME);
        }

        return hrv;
    }
}
