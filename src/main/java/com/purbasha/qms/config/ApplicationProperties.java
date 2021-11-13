package com.purbasha.qms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@PropertySources({
        @PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
})
@Component
public class ApplicationProperties {

    private final Async async = new Async();

    private final Cache cache = new Cache();

    private final Mail mail = new Mail();

    private final Security security = new Security();

    private final Swagger swagger = new Swagger();

    private final CorsConfiguration cors = new CorsConfiguration();

    private final Payment payment = new Payment();

    public Async getAsync() {
        return async;
    }

    public Cache getCache() {
        return cache;
    }

    public Mail getMail() {
        return mail;
    }

    public Security getSecurity() {
        return security;
    }

    public Swagger getSwagger() {
        return swagger;
    }

    public CorsConfiguration getCors() {
        return cors;
    }

    public Payment getPayment() {
        return payment;
    }

    public static class Async {

        private int corePoolSize = 2;

        private int maxPoolSize = 50;

        private int queueCapacity = 10000;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }


    public static class Cache {

        private final Hazelcast hazelcast = new Hazelcast();

        public Hazelcast getHazelcast() {
            return hazelcast;
        }

        public static class Hazelcast {

            private int timeToLiveSeconds = 3600;

            private int backupCount = 1;

            private final ManagementCenter managementCenter = new ManagementCenter();

            public ManagementCenter getManagementCenter() {
                return managementCenter;
            }

            public static class ManagementCenter {

                private boolean enabled = false;

                private int updateInterval = 3;

                private String url =  "http://localhost:8180/mancenter";

                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public int getUpdateInterval() {
                    return updateInterval;
                }

                public void setUpdateInterval(int updateInterval) {
                    this.updateInterval = updateInterval;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

            }

            public int getTimeToLiveSeconds() {
                return timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public int getBackupCount() {
                return backupCount;
            }

            public void setBackupCount(int backupCount) {
                this.backupCount = backupCount;
            }
        }

    }

    public static class Mail {

        private boolean enabled = true;

        private String from = "application@localhost";

        private String baseUrl = "http://127.0.0.1:4200";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Security {

        private final Authentication authentication = new Authentication();

        public Authentication getAuthentication() {
            return authentication;
        }

        public static class Authentication {

            private final Jwt jwt = new Jwt();

            public Jwt getJwt() {
                return jwt;
            }

            public static class Jwt {

                private String secret = "Y2IzMTk3NzMzZDM1ZjI1NmYzMjJiNzc3NTAyNGFjNWIxNmNhNjNjZTRmNjgxNjgyNjU0YzI2Y2QxNjc4MGEzNWI2MWUyMzc1MzQwMDU0ZGE0MjEyOTI0OTQyZDU1YjYxMzQ4YjUwOTlkYTZmNWMyOTRlYWRjZTYyNTAzYjY4MzA=";

                private long tokenValidityInSeconds = 86400;

                private long tokenValidityInSecondsForRememberMe = 2592000;

                public String getSecret() {
                    return secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public long getTokenValidityInSeconds() {
                    return tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }
    }

    public static class Swagger {

        private String title = "Purbasha QMS API";

        private String description = "Purbasha QMS API Documentation";

        private String version = "0.0.1";

        private String termsOfServiceUrl = "";

        private String contactName = "Kalyan Das";

        private String contactUrl = "www.optimizeitsystems.com";

        private String contactEmail = "kalyan.das@optimizeitsystems.com";

        private String license = "";

        private String licenseUrl = "";

        private String defaultIncludePattern = "";

        private String[] protocols = new String[0];

        private String host = null;

        private boolean useDefaultResponseMessages = true;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return protocols;
        }

        public void setProtocols(String[] protocols) {
            this.protocols = protocols;
        }

        public boolean isUseDefaultResponseMessages() {
            return useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }
    }


    public static class Payment {
        private String merchantKey;
        private String merchantSalt;
        private String callbackUrl;
        private String payurl;
        private String callbackResponseUrl;
        private String vfcallbackUrl;
        private String vfcallbackResponseUrl;

        public String getMerchantKey() {
            return merchantKey;
        }

        public void setMerchantKey(String merchantKey) {
            this.merchantKey = merchantKey;
        }

        public String getMerchantSalt() {
            return merchantSalt;
        }

        public void setMerchantSalt(String merchantSalt) {
            this.merchantSalt = merchantSalt;
        }

        public String getCallbackUrl() {
            return callbackUrl;
        }

        public void setCallbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
        }

        public String getPayurl() {
            return payurl;
        }

        public void setPayurl(String payurl) {
            this.payurl = payurl;
        }

        public String getCallbackResponseUrl() {
            return callbackResponseUrl;
        }

        public void setCallbackResponseUrl(String callbackResponseUrl) {
            this.callbackResponseUrl = callbackResponseUrl;
        }

        public String getVfcallbackUrl() {
            return vfcallbackUrl;
        }

        public void setVfcallbackUrl(String vfcallbackUrl) {
            this.vfcallbackUrl = vfcallbackUrl;
        }

        public String getVfcallbackResponseUrl() {
            return vfcallbackResponseUrl;
        }

        public void setVfcallbackResponseUrl(String vfcallbackResponseUrl) {
            this.vfcallbackResponseUrl = vfcallbackResponseUrl;
        }
    }

}
