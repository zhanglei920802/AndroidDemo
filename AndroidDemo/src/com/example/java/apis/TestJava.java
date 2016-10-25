
package com.example.java.apis;

/**
 * 测试Java中位运算 <br>
 * 
 * @Author<br>leizhang
 * @Since<br>2015年7月3日
 */
public class TestJava {
    public static final int FLAG_ACTIVITY_CONSTRUCTOR = 0x0000;
    public static final int FLAG_ACTIVITY_CREATE = 0x0001;
    public static final int FLAG_ACTIVITY_START = 0x0002;
    public static final int FLAG_ACTIVITY_RESUME = 0x0003;
    public static final int FLAG_ACTIVITY_PAUSE = 0x0004;
    public static final int FLAG_ACTIVITY_STOP = 0x0005;
    public static final int FLAG_ACTIVITY_DESTROY = 0x0006;

    public static final int MASK_ACTIVITY_LIFE = 0x000F;

    private int mPrivateFlags = 0x0000;

    public static void main(String[] args) {
        TestJava java = new TestJava();
        java. setFlags(true, FLAG_ACTIVITY_START, MASK_ACTIVITY_LIFE);
        java.setFlags(true, FLAG_ACTIVITY_PAUSE, MASK_ACTIVITY_LIFE);
        java.setFlags(true, FLAG_ACTIVITY_DESTROY, MASK_ACTIVITY_LIFE);
        
        System.out.println(java.hasFlags(FLAG_ACTIVITY_START, MASK_ACTIVITY_LIFE));
        java. setFlags(false, FLAG_ACTIVITY_START, MASK_ACTIVITY_LIFE);
        System.out.println(java.hasFlags(FLAG_ACTIVITY_START, MASK_ACTIVITY_LIFE));
    }
    private final void setFlags(boolean set, int flags) {
        setFlags(set, flags, flags);
    }

    private final void setFlags(boolean set, int flags, int mask) {
        if (set) {
//            mPrivateFlags &= ~mask;
            mPrivateFlags |= mask & flags;
        } else {
            mPrivateFlags &= ~mask;
        }
    }

    private final boolean hasFlags(int flags, int mask) {
        return (flags & mask) != 0;
    }
}
