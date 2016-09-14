package demo.upload.http;

import com.google.common.base.Strings;

public class HttpReturnValue {
    private String dirPath;
    private String sourceFileName;
    private String destFileName;
    private boolean success;
    private String fullPathFile;

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public void setDestFileName(String destFileName) {
        this.destFileName = destFileName;
    }

    public String getDirPath() {

        return dirPath;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public String getDestFileName() {
        return destFileName;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setFullPathFile(String fullPathFile) {
        this.fullPathFile = fullPathFile;
    }

    public String getFullPathFile() {
        String dirPath = getDirPath();
        String destFileName = getDestFileName();

        if (Strings.isNullOrEmpty(dirPath) || Strings.isNullOrEmpty(destFileName)) {
            return fullPathFile;
        }

        return getDirPath() + getDestFileName();
    }
}
