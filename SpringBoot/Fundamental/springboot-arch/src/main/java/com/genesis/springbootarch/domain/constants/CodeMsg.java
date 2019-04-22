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
     * all report job codes are started with 1
     */
    interface REPORT_FILE_NOT_FOUND {
        String CODE = "1000";
        String MSG = "Report File Not Found";
    }

    interface REPORT_FORMAT_ERROR {
        String CODE = "1001";
        String MSG = "Report Format Error";
    }

    interface REPORT_IMPORT_ERROR {
        String CODE = "1002";
        String MSG = "Report Import Error";
    }
}

