package com.genesis.easyexceldemo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.genesis.easyexceldemo.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : KG
 * description:
 * create date: 11:10 AM 2019/12/31
 * modified by:
 */

@Slf4j
public class UserExcelListener extends AnalysisEventListener<User> {

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 2;
    private List<User> list = new ArrayList<>(BATCH_COUNT);

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(user));
        list.add(user);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
    }
}

