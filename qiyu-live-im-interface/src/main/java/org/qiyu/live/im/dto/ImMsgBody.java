package org.qiyu.live.im.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chenH
 * @desc
 * @date 2023/12/13/ 13:11
 */

public class ImMsgBody implements Serializable {
    @Serial
    private static final long serialVersionUID = -7657602083071950966L;

    private int appid;

    private long userid;

    private String token;

    private String data;

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImMsgBody{");
        sb.append("appid=").append(appid);
        sb.append(", userid=").append(userid);
        sb.append(", token='").append(token).append('\'');
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
