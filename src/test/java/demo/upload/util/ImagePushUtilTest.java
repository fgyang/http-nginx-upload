package demo.upload.util;

import demo.upload.http.HttpReturnValue;
import org.junit.Test;

import java.io.File;

public class ImagePushUtilTest {
    @Test
    public void testImageUpload() {
        File file = new File("test.jpg");
        HttpReturnValue hrv = ImagePushUtil.push(file);
        System.out.println(hrv.getFullPathFile());
    }
}
