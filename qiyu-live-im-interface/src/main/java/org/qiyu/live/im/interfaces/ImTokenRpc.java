package org.qiyu.live.im.interfaces;

/**
 * @author chenH
 * @desc
 * @date 2023/12/13/ 15:07
 */

public interface ImTokenRpc {

    /**
     * @author chenH
     * @desc 创建用户登录im服务器的token
     * @date 2023/12/13/ 15:07
     */
    String createImLoginToken(long userId, int appId);

    /**
     * @author chenH
     * @desc 根据token检索用户id
     * @date 2023/12/13/ 15:07
     */
    Long getUserIdByToken(String token);
}
