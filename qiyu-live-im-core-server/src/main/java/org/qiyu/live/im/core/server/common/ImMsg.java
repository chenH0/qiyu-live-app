package org.qiyu.live.im.core.server.common;

import org.qiyu.live.im.constants.ImConstants;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chenH
 * @desc 处理消息的消息体
 * @date 2023/12/06/ 22:18
 */

public class ImMsg implements Serializable {
    @Serial
    private static final long serialVersionUID = -656741787378054198L;
    // 魔术 用于基本校验
    private short magic;

    // 记录body的长度
    private int len;

    // 用于标识当前消息的作用，交给不同的handler处理
    private int code;

    // 存储消息体的内容，按字节的方式去存取
    private byte[] body;

    public static ImMsg build(int code, String data) {
        ImMsg imMsg = new ImMsg();
        imMsg.setMagic(ImConstants.DEFAULT_MAGIC);
        imMsg.setCode(code);
        imMsg.setBody(data.getBytes());
        imMsg.setLen(imMsg.getBody().length);
        return imMsg;
    }

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImMsg{");
        sb.append("magic=").append(magic);
        sb.append(", len=").append(len);
        sb.append(", code=").append(code);
        sb.append(", body=");
        if (body == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < body.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(body[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
