package org.qiyu.live.im.core.server.common;

/**
 * @author chenH
 * @desc 处理消息的消息体
 * @date 2023/12/06/ 22:18
 */

public class ImMsg {
    // 魔术 用于基本校验
    private short magic;

    // 记录body的长度
    private int len;

    // 用于标识当前消息的作用，交给不同的handler处理
    private int code;

    // 存储消息体的内容，按字节的方式去存取
    private byte[] body;

    public short getMagic() {
        return magic;
    }

    public void setMagic(short magic) {
        this.magic = magic;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
