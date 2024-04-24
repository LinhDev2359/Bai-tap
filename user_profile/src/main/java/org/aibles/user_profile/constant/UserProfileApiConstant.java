package org.aibles.user_profile.constant;

import static org.aibles.user_profile.constant.UserProfileApiConstant.ApiConstant.API_PREFIX;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ApiConstant.API_VERSION;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.AUTH;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.POST;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.USER_PROFILE;

public class UserProfileApiConstant {

  public static class ApiConstant {
    public static final String API_PREFIX = "/api";
    public static final String API_VERSION = "/v1";
  }

  public static class ResourceConstant {
    public static final String USER_PROFILE = "/user-profiles";
    public static final String POST = "/posts";
    public static final String IMAGE = "/images";
    public static final String AUTH = "/account";
    public static final String REACTION = "/reactions";
  }

  public static class BaseUrl {

    public static final String USER_PROFILE_URL = API_PREFIX + API_VERSION + USER_PROFILE;
    public static final String POST_URL = API_PREFIX + API_VERSION + POST;
    public static final String AUTH_URL = API_PREFIX + API_VERSION + AUTH;

  }
}
