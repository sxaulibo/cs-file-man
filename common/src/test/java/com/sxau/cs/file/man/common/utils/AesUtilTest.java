package com.sxau.cs.file.man.common.utils;

import org.junit.jupiter.api.Test;

class AesUtilTest {

    @Test
    void encrypt() {
        try {
            String r = AesUtil.encrypt("{\"active\":true,\"avatar\":\"\",\"department\":[1],\"errcode\":0,\"errmsg\":\"ok\",\"isAdmin\":true,\"isBoss\":false,\"isHide\":false,\"isLeaderInDepts\":\"{1:false}\",\"isSenior\":false,\"name\":\"贺攀峰\",\"orderInDepts\":\"{1:176328781527043512}\",\"roles\":[{\"groupName\":\"默认\",\"id\":1367394325,\"name\":\"主管理员\",\"type\":101}],\"tags\":{},\"unionid\":\"wOLYBRRFR0pmM9tQBuPZuQiEiE\",\"userid\":\"manager9658\"}", "72f54ba3482d3f109c4d4cecfeb95dcf");
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void decrypt() {
        try {
            String r = AesUtil.decrypt("2yTNH5B5HZ92oDeLvMEyyLOQxiPwF1KcgRHqAkz5BN3t5QxkVZyn0Gq3WqJAoqmO1nRUU4dphl6o\n" +
                    "0SQkh46/9h0Cqxe/EfB55YHgtnYjBKuob8ng5s5F9itoeCzvxDn6g4JzKBJLlUYvAf/ZXb8RMmge\n" +
                    "zeQY0/0hGJgnKWfT2BUkALxfpAIOZPNExDTDlXr950CA1n/VFWBdAXEQG/fmB5RN+2z1/FFBmYUV\n" +
                    "jNNGhaYIHUVoWNy5sAegK57Xkebq+cLXbX3YCeQDSr0dnqagDj7CLTxL6RwUdth9Pp5Sw7bq/alU\n" +
                    "ru97bMTK/VI6tKb2qCA5Im8qX4WIHLi6fTN/Psj8VHiqPOJ1q5hgaPURpzZA/UABsJjT2uBioQWK\n" +
                    "4pRHig3i8zFE2+tRZvYmwevKWvf7/PVSu7rmfWC9Two4Gq1TufNqdbV1iHwJ3gjdYGtR5AdgtIrx\n" +
                    "cnS9eQ5i58Pgj8xL/YEC62GAJb6YI573HsM0D4TdLykgQGTDUSDitauX", "72f54ba3482d3f109c4d4cecfeb95dcf");
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseByte2HexStr() {
    }

    @Test
    void parseHexStr2Byte() {
    }

    @Test
    void customSaltContent() {
    }
}