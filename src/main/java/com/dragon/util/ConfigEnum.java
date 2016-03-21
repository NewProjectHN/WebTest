package com.dragon.util;

/**
 * Constant of properties file
 * @author ndlong
 *
 */
public enum ConfigEnum {
	URI_PATH_API("http://energisme.com/"),
	SITE_ID("1"),
	LOGO_PATH("../img/CarreFour.png"),
	LOGO_ELECLERC_PATH("../img/ELeclerc.png"),
	LOGO_BOUYGUES_PATH("../img/bouygues.png"),
	LOGO_LAB004_PATH(""),
	LOGO_LAB005_PATH(""),
	LOGO_LAB007_PATH(""),
	LOGO_LAB008_PATH(""),
	SITE_INFO(""),
	DAY_GET_CONSUMPTION("7"),
	HOUR_GET_TEMPERATURE("24"),
	USER_NAME_ACCESS("unknow"),
	Range_APlus_Min("0"),
	Range_APlus_Max("300"),
	Range_A_Min("301"),
	Range_A_Max("350"),
	Range_B_Min("351"),
	Range_B_Max("400"),
	Range_C_Min("401"),
	Range_C_Max("450"),
	Range_D_Min("451"),
	Range_D_Max("500"),
	Range_E_Min("501"),
	Range_E_Max("550"),
	Range_F_Min("551"),
	Range_F_Max("600"),
	Range_G_Min("601"),
	Range_G_Max("650"),
	Range_H_Min("651"),
	Range_H_Max("700"),
	Range_I_Min("701"),
	IS_CURRENT_TIME("YES"),
	CURRENT_TIME_YEAR("2015"),
	CURRENT_TIME_MONTH("4"),
	CURRENT_TIME_DAY("10"),
	CURRENT_TIME_HOUR("9"),
	PDF_BACKLOG_LINK(""),
	PDF_BACKLOG_LINK_ELECLERC(""),
	PDF_REPORT_BOUYGUES_LINK(""),
	URI_WEB_SERVICE(""),
//	number_energy_current_year("1"),
	LAB_NAME_001("lab001"),
	LAB_NAME_002("lab002"),
	LAB_NAME_003("lab003"),
	LAB_NAME_004("lab004"),
	LAB_NAME_005("lab005"),
	LAB_NAME_006("lab006"),
	LAB_NAME_007("lab007"),
	LAB_NAME_008("lab008"),
	LAB_NAME_MONITOR("monitor"),
	LAB004_DATA_TIME("1"),
	REPORT_LAB004_LINK(""),
	REPORT_LAB005_LINK(""),
	REPORT_LAB006_LINK(""),
	REPORT_LAB006_CLIENT_LINK(""),
	IMAGE_LAB006_CLIENT_LINK(""),
	REPORT_LAB007_LINK("/home/ocr/labconfig/report/lab007"),
	REPORT_LAB008_LINK("/home/ocr/labconfig/report/lab007"),
	URI_PATH_LOGIN("http://energisme.com/"),
	LAB006_REPORT_GLOBAL(""),
	LAB006_REPORT_CLIENT("")
    ;
    /** Configuration default value, use incase setting value is null */
    private String def;

    private ConfigEnum(String def) {
        this.def = def;
    }

    /**
     * Get value of def.
     *
     * @return the def
     */
    public String getDef() {
        return def;
    }
    
}
