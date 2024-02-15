package com.jump.toolsshop.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2Util {

    private static final int ITERATIONS = 2;
    private static final int MEMORY = 65536; // 64MB
    private static final int PARALLELISM = 1;

    private static final Argon2 argon2 = Argon2Factory.create();

    // 生成密码的哈希值
    public static String hashPassword(String password) {
        // 参数：iterations, memory, parallelism
        return argon2.hash(ITERATIONS, MEMORY, PARALLELISM, password.toCharArray());
    }

    // 验证密码
    public static boolean verifyPassword(String hashedPassword, String password) {
        return argon2.verify(hashedPassword, password.toCharArray());
    }

    // 清除敏感信息，很重要！
    public static void wipeArray(char[] array) {
        if (array != null) {
            argon2.wipeArray(array);
        }
    }
}

