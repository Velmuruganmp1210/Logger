package com.awin.api;

/**
 * The type Smtp detail.
 */
public class SMTPDetail {

   private String hostname;
    private String port;
    private String username;
    private String password;
    private String fromAddress;
    private String toAddress;

    /**
     * Gets hostname.
     *
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets hostname.
     *
     * @param hostname the hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets port.
     *
     * @param port the port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets from address.
     *
     * @return the from address
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * Sets from address.
     *
     * @param fromAddress the from address
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    /**
     * Gets to address.
     *
     * @return the to address
     */
    public String getToAddress() {
        return toAddress;
    }

    /**
     * Sets to address.
     *
     * @param toAddress the to address
     */
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
}
