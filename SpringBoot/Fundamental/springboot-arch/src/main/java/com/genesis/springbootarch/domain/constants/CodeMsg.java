package com.genesis.springbootarch.domain.constants;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:32 PM 2019/4/13
 * @modified by:
 */

public interface CodeMsg {
    interface SUCC {
        String CODE = "0000";
        String MSG = "Success";
    }

    interface EXCEPT {
        String CODE = "5000";
        String MSG = "Unknown Exception";
    }

    /**
     * exceptions and codes
     */
    interface NULL_POINTER_EXCEPTION {
        String CODE = "5001";
        String MSG = "Null Pointer Exception";
    }
}

