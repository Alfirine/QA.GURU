package models.login;

import lombok.Data;

@Data
public class FeatureFlags {
    private Boolean isOrganizationEnterprise;
    private Boolean isOrganizationEnabled;
    private Boolean isBrandingEnabled;
    private Boolean isConversionEnabled;
    private Boolean isCourseEnabled;
    private Boolean isCertificate;
}
