package com.sxau.cs.file.provider.model.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -4638359968179580641L;

    /**
     * 状态
     *
     * @see com.sxau.cs.file.provider.constants.Constant.Stat
     */
    private String stat;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
