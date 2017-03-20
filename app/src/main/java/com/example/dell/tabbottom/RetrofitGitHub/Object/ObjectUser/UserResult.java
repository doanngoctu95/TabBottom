package com.example.dell.tabbottom.RetrofitGitHub.Object.ObjectUser;

/**
 * Created by dell on 08/12/2016.
 */
public class UserResult {
    private String avataUrl;
    private String loginName;
    private String score;

    public UserResult(String avataUrl, String loginName, String score) {
        this.avataUrl = avataUrl;
        this.loginName = loginName;
        this.score = score;
    }

    public UserResult() {
    }

    public String getAvataUrl() {
        return avataUrl;
    }

    public void setAvataUrl(String avataUrl) {
        this.avataUrl = avataUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
