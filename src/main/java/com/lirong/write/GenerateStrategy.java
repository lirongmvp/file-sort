package com.lirong.write;

/**
 * @author LiRong
 */
public class GenerateStrategy {
    //融合递归的目录
    private static String generatePath;
    //第一次的准备目录
    private static String perMergeFile;

    public static String getPerMergeFile() {
        return perMergeFile;
    }

    public static void setPerMergeFile(String perMergeFile) {
        GenerateStrategy.perMergeFile = perMergeFile;
    }

    public static String getGeneratePath() {
        return generatePath;
    }

    public static void setGeneratePath(String generatePath) {
        GenerateStrategy.generatePath = generatePath;
    }

    public static String preMerge(Integer i){

        return perMergeFile + i + ".txt";
    }

    public static String generatePath(Integer i){

        return generatePath + i + ".txt";
    }

}
