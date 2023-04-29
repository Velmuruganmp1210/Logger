package com.awin.api;

/**
 * The type Configuration.
 */
public class Configuration {

    /**
     * Gets filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets filename.
     *
     * @param filename the filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets api url.
     *
     * @return the api url
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * Sets api url.
     *
     * @param apiUrl the api url
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }


    /**
     * Gets smtp details.
     *
     * @return the smtp details
     */
    public SMTPDetail getSMTPDetails() {
        return SMTPDetails;
    }

    /**
     * Sets smtp details.
     *
     * @param SMTPDetails the smtp details
     */
    public void setSMTPDetails(SMTPDetail SMTPDetails) {
        this.SMTPDetails = SMTPDetails;
    }

    /**
     * Gets file pattern.
     *
     * @return the file pattern
     */
    public String getFilePattern() {
        return filePattern;
    }

    /**
     * Sets file pattern.
     *
     * @param filePattern the file pattern
     */
    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }

    private SMTPDetail SMTPDetails;
    private String apiUrl;
    private String filename;



    private String filePattern;

}
