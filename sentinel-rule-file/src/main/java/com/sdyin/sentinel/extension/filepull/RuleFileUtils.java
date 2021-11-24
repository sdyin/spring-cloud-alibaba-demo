package com.sdyin.sentinel.extension.filepull;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 创建规则持久化目录和文件的工具类
 *
 * @author Fox
 */
public class RuleFileUtils {

    public static void mkdirIfNotExits(String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            System.out.println("【文件不存在,新建文件路径】path:" + filePath);
            file.mkdirs();
        }
    }

    public static void createFileIfNotExits(Map<String,String> ruleFileMap) throws IOException {

        Set<String> ruleFilePathSet = ruleFileMap.keySet();
        Iterator<String> ruleFilePathIter = ruleFilePathSet.iterator();
        while (ruleFilePathIter.hasNext()) {
            String ruleFilePathKey = ruleFilePathIter.next();
            String ruleFilePath  = PersistenceRuleConstant.rulesMap.get(ruleFilePathKey).toString();
            File ruleFile = new File(ruleFilePath);
            if(!ruleFile.exists()) {
                ruleFile.createNewFile();
            }
        }
    }

}