package com.hr.constant;

/**
 * 
 * TODO session key manage
 * @author taoZi
 * @version V1.0
 */
public interface SessionKeys {

    interface UserSessionKeys {
        /** user's session key **/
        public static final String SESSION_USER = "SESSION_USER";

        /** user's directory session key **/
        public static final String SESSION_USER_DIRECTORY = "SESSION_USER_DIRECTORY";

        /** user's privilege session key **/
        public static final String SESSION_USER_PRIVILEGE = "SESSION_USER_PRIVILEGE";

        /** 每个url对应的权限分类集合key **/
        public static final String SESSION_URL_PRIVILEGE = "SESSION_URL_PRIVILEGE";

        /** 每个url对应的选项list **/
        public static final String SESSION_URL_OPTIONS = "SESSION_URL_OPTIONS";
    }

    class ConfParam {
        /** confParas's session key */
        public static String getKey(Integer secondLevelId) {
            return "confParam_" + secondLevelId;
        }
    }

}
